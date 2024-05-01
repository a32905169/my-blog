package com.example.blog.mapper;

import com.example.blog.dto.UserWithNumOfArt;
import com.example.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author chang
 * @create 2024-04-2024/4/26 下午 06:56
 */
@Mapper
public interface UserMapper {

    //根據username獲得指定User物件
    User selectByUserName(String username);

    //使用user對users表插入一條新數據
    Integer addUser(User user);

    //根據username更新最後登入時間
    Integer updateLastLogin(String username, Date lastLogin);

    //根據uid獲得用戶部分資訊與該用戶編寫之文章總數
    UserWithNumOfArt getInfoAndCount(Integer uid);

    //根據uid更新用戶信箱
    Integer updateEmailByUid(@Param("uid") Integer uid,@Param("email") String email);

    //根據uid獲得用戶以bCrypt加密之密碼密文
    String getOldPWD(Integer uid);

    //根據uid與新密碼對密碼進行更新
    Integer updatePWDByUid(@Param("uid") Integer uid,@Param("password") String newPWD);

    //根據uid與新上傳之頭像路徑對頭像進行更新
    Integer uploadAvatar(Integer uid,String avatar);


}
