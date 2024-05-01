package com.example.blog.service;

import com.example.blog.dto.ArticleUserInfo;
import com.example.blog.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chang
 * @create 2024-04-2024/4/28 上午 05:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleServiceTests {
    @Autowired
    private ArticleService articleService;
    @Test
    public void getAllListTest() {
        // 假設 getAllList 返回 Map<String, Object>，直接在聲明時初始化它
        Map<String, Object> map1 = articleService.getAllList(1);

        // 使用增強的 for 循環遍歷 map 的 entrySet
        for (Map.Entry<String, Object> entry : map1.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
    @Test
    public void getListByAuthorIdTest(){
        List<Article> list = articleService.getListByAuthorId(7);
        for (Article a: list
        ) {
            System.out.println(a);
        }
    }


    @Test
    public void addArticle(){
        Article article = new Article();
        article.setTitle("第一篇文章修改799");
        article.setSummary("1摘要修改7999");
        article.setContent("1有一天我遇到了修改7...9");
        articleService.addArticle(article,5);
    }

}
