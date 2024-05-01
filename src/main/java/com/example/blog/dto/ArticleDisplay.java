package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 存放點擊文章後前端需展示之文章詳細訊息與內容
 *
 * @author chang
 * @create 2024-04-2024/4/29 上午 03:23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDisplay {
    private Date createDate;
    private String title;
    private String username;
    private String content;
    private String summary;
}
