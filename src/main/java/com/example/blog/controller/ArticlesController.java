package com.example.blog.controller;

import com.example.blog.dto.ArticleDisplay;
import com.example.blog.dto.ArticleUserInfo;
import com.example.blog.pojo.Article;
import com.example.blog.service.ArticleService;
import com.example.blog.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author chang
 * @create 2024-04-2024/4/28 上午 03:40
 */
@RestController
@RequestMapping("/articles/")
public class ArticlesController {
    @Autowired
    private ArticleService articleService;

    /**
     * 根據指定頁碼回傳對應分頁後之文章陣列與數據庫中文章總數
     *
     * @param page 指定頁碼
     * @return
     */
    @RequestMapping("getAllList")
    public JsonResult<Map<String,Object>> getAllList(Integer page){
        JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
        Map<String,Object> map = articleService.getAllList(page);
        jsonResult.setStatus(200);
        jsonResult.setResult(map);
        return jsonResult;
    }


    /**
     * 根據登入用戶uid回傳文章陣列
     *
     * @param session
     * @return
     */
    @RequestMapping("getListByAuthorId")
    public JsonResult<List<Article>> getListByAuthorId(HttpSession session){
        JsonResult<List<Article>> jsonResult = new JsonResult<>();
        Integer uid = (Integer) session.getAttribute("uid");
        List<Article> list = articleService.getListByAuthorId(uid);
        jsonResult.setStatus(200);
        jsonResult.setResult(list);
        return jsonResult;
    }

    /**
     * 根據articleId刪除對應文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping("details/{articleId}")
    public JsonResult<ArticleDisplay> getArtDisplayByAid(@PathVariable Integer articleId){
        JsonResult<ArticleDisplay> jsonResult = new JsonResult<>();
        ArticleDisplay articleDisplay = articleService.getArtDisplayByAid(articleId);
        jsonResult.setStatus(200);
        jsonResult.setResult(articleDisplay);
        return jsonResult;
    }

    /**
     * 更新任一指定文章之內容
     * 沒使用rest風格，因為aid已經包含在article裡面
     *
     * @param article
     * @param session
     * @return
     */
    @RequestMapping("update/**")
    public JsonResult<Void> setArticleByAid(@RequestBody Article article, HttpSession session){
        JsonResult<Void> jsonResult = new JsonResult<>();
        Integer uid = (Integer)session.getAttribute("uid");
        articleService.setArticleByAid(article,uid);
        jsonResult.setStatus(200);
        return jsonResult;
    }


    /**
     * 根據用戶uid新增一篇文章
     *
     * @param article
     * @param session
     * @return
     */
    @RequestMapping("create")
    public JsonResult<Void> createArticle(@RequestBody Article article, HttpSession session){
        JsonResult<Void> jsonResult = new JsonResult<>();
        Integer uid = (Integer)session.getAttribute("uid");
        articleService.addArticle(article,uid);
        jsonResult.setStatus(200);
        return jsonResult;
    }


    /**
     * 根據aid刪除對應文章
     *
     * @param articleId
     * @param session
     * @return
     */
    @RequestMapping("delete/{articleId}")
    public JsonResult<Void> deleteArticleByAid(@PathVariable Integer articleId, HttpSession session){
        JsonResult<Void> jsonResult = new JsonResult<>();
        Integer uid = (Integer)session.getAttribute("uid");
        articleService.deleteArticleByAid(articleId,uid);
        jsonResult.setStatus(200);
        return jsonResult;
    }


}
