package com.example.blog.mapper;

import com.example.blog.dto.ArticleDisplay;
import com.example.blog.dto.ArticleUserInfo;
import com.example.blog.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author chang
 * @create 2024-04-2024/4/28 上午 04:18
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleMapperTests {
    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void getAllListTest(){
        List<ArticleUserInfo> list = articleMapper.getAllList(10);
        for (ArticleUserInfo a: list
             ) {
            System.out.println(a);
        }
    }

    @Test
    public void getListByAuthorIdTest(){
        List<Article> list = articleMapper.getListByAuthorId(9);
        for (Article a: list
        ) {
            System.out.println(a);
        }
    }

    @Test
    public void getArtDisplayByAid(){
        ArticleDisplay articleDisplay = articleMapper.getArtDisplayByAid(25);
        System.out.println(articleDisplay);

    }

    @Test
    public void updateArticleByAid(){
        Article article = new Article();
        article.setAid(((Integer)25).longValue());
        article.setTitle("第一篇文章修改7");
        article.setSummary("1摘要修改7");
        article.setContent("1有一天我遇到了修改7...");
        articleMapper.updateArticleByAid(article,7);
    }
    @Test
    public void insertArticle(){
        Article article = new Article();
        article.setTitle("第一篇文章修改7");
        article.setSummary("1摘要修改7");
        article.setContent("1有一天我遇到了修改7...");
        article.setAuthorId(((Integer)5).longValue());
        article.setCreateDate(new Date());
        articleMapper.insertArticle(article);
    }


    @Test
    public void dropArticleByAid(){
        articleMapper.dropArticleByAid(41,7);
    }

}
