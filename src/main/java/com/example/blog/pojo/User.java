package com.example.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chang
 * @create 2024-04-2024/4/26 下午 06:36
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //users表自增主鍵
    private Integer uid;

    //用戶名稱，同時為登入帳號
    private String username;

    //用戶密碼
    private String password;

    //用戶信箱
    private String email;

    //用戶帳號創建時間
    private Date registrationDate;

    //用戶最後登入時間
    private Date lastLogin;

}
