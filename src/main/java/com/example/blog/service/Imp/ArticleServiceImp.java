package com.example.blog.service.Imp;

import com.example.blog.dto.ArticleDisplay;
import com.example.blog.dto.ArticleUserInfo;
import com.example.blog.mapper.ArticleMapper;
import com.example.blog.pojo.Article;
import com.example.blog.service.ArticleService;
import com.example.blog.service.ex.InsertException;
import com.example.blog.service.ex.SelectException;
import com.example.blog.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author chang
 * @create 2024-04-2024/4/28 上午 04:25
 */
@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Map<String, Object> getAllList(Integer pageNum) {
        Integer articleCount =  articleMapper.getAllCount();
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;  // 如果 pageNum 為 null 或無效，则默認為第一頁
        }
        if(articleCount == null){
            throw new SelectException();
        }
        List<ArticleUserInfo> list = articleMapper.getAllList((pageNum - 1) * 4);
        Map<String,Object> map = new HashMap<>();
        map.put("totalCount",articleCount);
        map.put("list",list);

        return map;
    }

    @Override
    public List<Article> getListByAuthorId(Integer uid) {
        return articleMapper.getListByAuthorId(uid);
    }

    @Override
    public ArticleDisplay getArtDisplayByAid(Integer aid) {
        return articleMapper.getArtDisplayByAid(aid);
    }




    @Override
    @Transactional
    public void setArticleByAid(Article article, Integer uid) {
        Integer integer = articleMapper.updateArticleByAid(article,uid);
        if (integer == null || integer != 1){
            throw new UpdateException("更新數據失敗");
        }
    }

    @Override
    @Transactional
    public void addArticle(Article article, Integer uid) {
        article.setCreateDate(new Date());
        article.setAuthorId(uid.longValue());
        Integer integer =articleMapper.insertArticle(article);
        if (integer == null || integer != 1){
            throw new InsertException("添加數據發生錯誤");
        }
    }

    @Override
    public void deleteArticleByAid(Integer aid, Integer uid) {
        Integer integer = articleMapper.dropArticleByAid(aid,uid);
        if (integer == null || integer != 1){
            throw new UpdateException("更新資料時發生錯誤");
        }
    }
}
