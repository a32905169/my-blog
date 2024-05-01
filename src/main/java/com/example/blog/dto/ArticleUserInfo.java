package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 存放主頁面陳列之簡要文章訊息
 *
 * @author chang
 * @create 2024-04-2024/4/28 上午 04:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUserInfo {
    private Long aid;
    private Date createDate;
    private String title;
    private String username;
    private String summary;
}
