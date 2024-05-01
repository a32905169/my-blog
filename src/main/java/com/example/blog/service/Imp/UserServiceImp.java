package com.example.blog.service.Imp;

import com.example.blog.dto.UserWithNumOfArt;
import com.example.blog.mapper.UserMapper;
import com.example.blog.pojo.User;
import com.example.blog.service.UserService;
import com.example.blog.service.ex.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author chang
 * @create 2024-04-2024/4/26 下午 06:46
 */

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    @Transactional
    public void register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User oldUser = userMapper.selectByUserName(username);
        if (oldUser != null){
            throw new UserAlreadyExistsException("用戶名已被註冊");
        }
        String newPD = bCryptPasswordEncoder.encode(password);
        user.setPassword(newPD);
        user.setRegistrationDate(new Date());
        Integer row = userMapper.addUser(user);
        if(row == null || row != 1){
            throw new InsertException("註冊時發生異常");
        }

    }

    @Override
    @Transactional
    public User login(String username, String password) {
        User oldUser = userMapper.selectByUserName(username);
        if(oldUser == null){
            throw new UserNotFoundException("用戶名錯誤或不存在");
        }
        String oldUserPD = oldUser.getPassword();
        boolean correct = bCryptPasswordEncoder.matches(password,oldUserPD);
        if (!correct){
            throw new PWDNotCorrectException("帳號或密碼錯誤");
        }
        Integer rows = userMapper.updateLastLogin(username,new Date());
        if(rows == null || rows != 1){
            throw new UpdateException("登入時發生錯誤");
        }
        return oldUser;
    }


    @Override
    public UserWithNumOfArt numberOfArticle(Integer uid) {
        return userMapper.getInfoAndCount(uid);
    }


    @Override
    @Transactional
    public void updateEmailByUid(Integer uid, String email) {
        Integer integer = userMapper.updateEmailByUid(uid,email);
        if (integer ==null || integer != 1){
            throw new UpdateException("更新發生錯誤");
        }
    }


    @Override
    @Transactional
    public void updatePWDByUid(Integer uid,String oldPwd,String newPwd) {
        String oldBcrPWD = userMapper.getOldPWD(uid);
        if (oldBcrPWD == null){
            throw new SelectException("數據發生錯誤");
        }
        if (!bCryptPasswordEncoder.matches(oldPwd,oldBcrPWD)){
            throw new PWDNotCorrectException("原密碼輸入錯誤");
        }
        Integer integer = userMapper.updatePWDByUid(uid,bCryptPasswordEncoder.encode(newPwd));
        if (integer == null || integer != 1){
            throw new UpdateException("更新密碼時發生錯誤");
        }
    }

    @Override
    @Transactional
    public void uploadAvatar(Integer uid, String avatar) {
        Integer integer = userMapper.uploadAvatar(uid,avatar);
        if (integer == null || integer != 1){
            throw new UpdateException("更新頭像發生錯誤");
        }
    }
}
