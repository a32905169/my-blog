package com.example.blog.mapper;

import com.example.blog.dto.ArticleDisplay;
import com.example.blog.dto.ArticleUserInfo;
import com.example.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chang
 * @create 2024-04-2024/4/28 上午 03:58
 */
@Mapper
public interface ArticleMapper {

    //獲得數據庫未刪除之總文章數
    Integer getAllCount();

    //根據pageNum獲得儲存指定頁數後4筆文章之陣列
    List<ArticleUserInfo> getAllList(Integer pageNum);

    //根據authorId獲得儲存該作者之所有文章陣列
    List<Article> getListByAuthorId(Integer authorId);

    //根據aid獲得該文章相關詳細內容
    ArticleDisplay getArtDisplayByAid(Integer aid);

    //根據article中屬性值aid更新文章內容，同時以uid確認是否為作者本人進行更新
    Integer updateArticleByAid(@Param("article") Article article, @Param("uid") Integer uid);

    //對articles表插入一筆新文章
    Integer insertArticle(Article article);

    //根據aid刪除文章內容，同時以uid確認是否為作者本人進行刪除
    Integer dropArticleByAid(@Param("aid") Integer aid,@Param("uid") Integer uid);

}
