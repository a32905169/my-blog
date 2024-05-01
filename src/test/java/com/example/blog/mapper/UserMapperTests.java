package com.example.blog.mapper;

import com.example.blog.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author chang
 * @create 2024-04-2024/4/26 下午 07:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void addUserTest(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        user.setEmail("root@");
        user.setRegistrationDate(new Date());
        user.setLastLogin(new Date());
        System.out.println(user);
        userMapper.addUser(user);
    }

    @Test
    public void selectByUserNameTest(){
        User user = userMapper.selectByUserName("root");
        System.out.println(user);
    }

    @Test
    public void updateLastLogin(){
        userMapper.updateLastLogin("root6",new Date());
    }
    @Test
    public void getInfoWithCount(){
        System.out.println(userMapper.getInfoAndCount(7));
    }


    @Test
    public void updateEmailByUid(){
        userMapper.updateEmailByUid(14,"5");
    }
    @Test
    public void getOldPWD(){
        System.out.println(userMapper.getOldPWD(14));
    }
    @Test
    public void updatePWDByUid(){
        userMapper.updatePWDByUid(14,"7777777");
    }




}
