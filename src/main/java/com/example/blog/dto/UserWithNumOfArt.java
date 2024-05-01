package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 存放前端需顯示的部分用戶數據
 *
 * @author chang
 * @create 2024-04-2024/4/28 上午 08:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithNumOfArt {

    private String avatar;
    private String email;

    private String username;

    //該用戶之文章總數
    private Integer numberOfArticle;


    private Date registrationDate;

}
