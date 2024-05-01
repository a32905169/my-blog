package com.example.blog.controller;

import com.example.blog.controller.ex.ControllerException;
import com.example.blog.controller.ex.CreateDirectoryException;
import com.example.blog.service.ex.*;
import com.example.blog.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * 用於捕獲異常，並將該異常對應之狀態碼與信息寫入物件以回傳置前端
 *
 * @author chang
 * @create 2024-04-2024/4/27 上午 03:34
 */
@RestControllerAdvice
public class BaseController {

    @ExceptionHandler({ServiceException.class, IOException.class, ControllerException.class})
    public JsonResult<Void> BaseExceptionHandler(Throwable throwable){
        JsonResult<Void> jsonResult = new JsonResult<>();
        if (throwable instanceof UserAlreadyExistsException){
            jsonResult.setStatus(4001);
            jsonResult.setMessage("用戶名已被註冊");
        }else if (throwable instanceof InsertException){
            jsonResult.setStatus(4002);
            jsonResult.setMessage("插入數據時發生錯誤");
        }else if (throwable instanceof UserNotFoundException){
            jsonResult.setStatus(4101);
            jsonResult.setMessage("無此帳號");
        }else if (throwable instanceof PWDNotCorrectException){
            jsonResult.setStatus(4102);
            jsonResult.setMessage("帳號或密碼錯誤");
        }else if (throwable instanceof UpdateException){
            jsonResult.setStatus(4103);
            jsonResult.setMessage("數據發生錯誤");
        }else if (throwable instanceof IOException){
            jsonResult.setStatus(4104);
            jsonResult.setMessage("寫入發生錯誤");
        }else if(throwable instanceof CreateDirectoryException){
            jsonResult.setStatus(4105);
            jsonResult.setMessage("創建目錄發生錯誤");
        }
        return jsonResult;
    }


}
