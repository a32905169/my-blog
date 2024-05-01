package com.example.blog.service;

import com.example.blog.dto.UserWithNumOfArt;
import com.example.blog.pojo.User;
import jakarta.servlet.http.HttpSession;

/**
 * @author chang
 * @create 2024-04-2024/4/26 下午 06:44
 */
public interface UserService {


    //註冊
    void register(User user);


    //登入
    User login(String username, String password);


    //根據uid回傳UserWithNumOfArt物件，此物件內含前端需要顯示的用戶資訊
    UserWithNumOfArt numberOfArticle(Integer uid);

    //根據uid更新信箱
    void updateEmailByUid(Integer uid,String email);


    //根據uid先進行舊密碼確認，正確後更新成新密碼
    void updatePWDByUid(Integer uid,String oldPwd,String newPwd);

    //根據uid存入上傳的頭像
    void uploadAvatar(Integer uid,String avatar);






}
