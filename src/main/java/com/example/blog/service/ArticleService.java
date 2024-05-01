package com.example.blog.service;

import com.example.blog.dto.ArticleDisplay;
import com.example.blog.pojo.Article;

import java.util.List;
import java.util.Map;

/**
 * @author chang
 * @create 2024-04-2024/4/28 上午 04:24
 */
public interface ArticleService {

    /**
     *主要用來處理分頁與文章展示
     *
     * @param integer 用戶指定之前端頁數
     * @return 內含兩組鍵值對的map，第一組:"totalCount"=articleCount，儲存執行當下數據庫中未刪除之所有文章總數
     *                            第二組:"list"=list<article>，根據sql語句"limit (integer - 1) * 4,4"對數據庫分頁後所返回之長度為4的陣列
     */
    Map<String, Object> getAllList(Integer integer);


    //根據uid對應之作者，回傳該作者撰寫的所有文章之陣列
    List<Article> getListByAuthorId(Integer uid);

    //根據uid回傳ArticleDisplay物件
    ArticleDisplay getArtDisplayByAid (Integer uid);

    //從article中獲得aid，再根據aid更新文章內容，同時以uid確認是否為作者本人修改
    void setArticleByAid(Article article,Integer uid);

    //添加新文章，同時以uid確認是否為本人添加
    void addArticle(Article article,Integer uid);

    //根據aid刪除文章，以uid判斷是否為本人修改
    void deleteArticleByAid(Integer aid,Integer uid);


}
