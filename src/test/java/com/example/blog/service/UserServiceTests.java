package com.example.blog.service;

import com.example.blog.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chang
 * @create 2024-04-2024/4/27 上午 03:00
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private UserService userService;
    @Test
    public void registerTest(){
        User user = new User();
        user.setUsername("root10");
        user.setPassword("root6");
        user.setEmail("root@");
        userService.register(user);
    }
    @Test
    public void loginTest(){
        userService.login("root6","root6");
    }


    @Test
    public void updatePWDByUid(){
        userService.updatePWDByUid(7,"777","root5");
    }
}
