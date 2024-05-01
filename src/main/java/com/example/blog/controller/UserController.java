package com.example.blog.controller;

import ch.qos.logback.core.util.FileUtil;
import com.example.blog.controller.ex.CreateDirectoryException;
import com.example.blog.controller.ex.FileIsEmptyException;
import com.example.blog.controller.ex.FileTypeException;
import com.example.blog.dto.UserWithNumOfArt;
import com.example.blog.pojo.User;
import com.example.blog.service.UserService;
import com.example.blog.util.JsonResult;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author chang
 * @create 2024-04-2024/4/26 下午 06:29
 */
@RestController
@RequestMapping({"/users/"})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("logOut")
    public void logOut(HttpSession session, HttpServletResponse httpServletResponse){
        session.setAttribute("uid",null);
        try {
            httpServletResponse.sendRedirect("/web/login.html");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }




    @RequestMapping("register")
    public JsonResult<Void> register(@RequestBody User user){
        userService.register(user);
        return new JsonResult<>(200,"註冊成功",null);
    }

    @RequestMapping("login")
    public JsonResult<Void> login(HttpSession session,String username,String password){
        User user = userService.login(username,password);
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());
        return new JsonResult<Void>(200,"登入成功",null);
    }


    /**
     * 根據session中的"uid"來回傳用戶名稱、頭像、文章數給前端右中上方的小框框，
     * 同時使用於修改個人資料前返回給前端資料
     *
     * @param session
     * @return
     */
    @RequestMapping("info")
    public JsonResult<UserWithNumOfArt> numberOfArticle(HttpSession session){
        JsonResult<UserWithNumOfArt> jsonResult = new JsonResult<>();
        Integer uid = (Integer)session.getAttribute("uid");
        UserWithNumOfArt userWithNumOfArt = userService.numberOfArticle(uid);
        jsonResult.setStatus(200);
        jsonResult.setResult(userWithNumOfArt);
        return jsonResult;

    }


    @RequestMapping("update/email")
    public JsonResult<Void> updateEmail(HttpSession session,@RequestBody String email){
        JsonResult<Void> jsonResult = new JsonResult<>();
        Integer uid = (Integer)session.getAttribute("uid");
        userService.updateEmailByUid(uid,email);
        jsonResult.setStatus(200);
        return jsonResult;

    }

    @RequestMapping("update/password")
    public JsonResult<Void> updatePWDByUid(HttpSession session, String oldPassword, String newPassword){
        JsonResult<Void> jsonResult = new JsonResult<>();
        Integer uid = (Integer)session.getAttribute("uid");
        userService.updatePWDByUid(uid,oldPassword,newPassword);
        jsonResult.setStatus(200);
        return jsonResult;
    }


    //存放允許上傳之所有頭像副檔名
    private static Set<String> set = new HashSet<>();
    static {
        set.add("jpg");
        set.add("jpeg");
        set.add("png");
        set.add("gif");
    }



    @RequestMapping("upload/avatar")
    public JsonResult<Void> uploadAvatar(HttpSession session,@RequestParam("avatar") MultipartFile formData) throws IOException{
        if(formData == null || formData.getOriginalFilename() == null || formData.isEmpty()){
            throw new FileIsEmptyException("上傳文件不可為空");
        }

        //獲取副檔名
        String extension = formData.getOriginalFilename().substring(formData.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();

        if(!set.contains(extension)){
            throw new FileTypeException("上傳檔案類型錯誤");
        }

        JsonResult<Void> jsonResult = new JsonResult<>();

        //指定頭像存放目錄路徑
        File file = new File("C:\\WorkSpaceIDEA\\web-all\\blog\\src\\main\\resources\\static\\images");

        if (!file.exists()){
            //生成目錄
            boolean b = file.mkdirs();
            if (!b){
                throw new CreateDirectoryException();
            }
        }

        //生成隨機檔案名稱
        String fileName = UUID.randomUUID().toString().toUpperCase() + "." + extension;

        //生成未寫入之檔案物件
        File pathfile = new File(file,fileName);

        //將formData寫入指定檔案物件
        formData.transferTo(pathfile);


        Integer uid = (Integer)session.getAttribute("uid");

        //根據uid存放對應用戶頭像路徑
        userService.uploadAvatar(uid,fileName);

        jsonResult.setStatus(200);
        return jsonResult;
    }


}
