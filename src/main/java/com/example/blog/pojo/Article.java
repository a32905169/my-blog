package com.example.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chang
 * @create 2024-04-2024/4/28 上午 03:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    //articles表自增主鍵
    private Long aid;

    //文章創建時間
    private Date createDate;

    //文章標題
    private String title;

    //文章觀看數，目前尚未實作此功能
    private int viewCounts;

    //與users表uid欄位外連接之欄位
    private Long authorId;

    //文章體、文章內容
    private String content;

    //標示文章是否刪除，0為未刪除、1為刪除
    private boolean isDeleted;

    //文章摘要
    private String summary;

}
