package com.example.blog.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author chang
 * @create 2024-04-2024/4/27 上午 05:05
 */
public class LoginInterceptor implements HandlerInterceptor {

    //使用session進行登入狀態會話控制，
    // 主要實現方法為判斷session中是否儲存uid鍵值對，以判斷用戶是否登入，
    //未登入則進行重定向，導向登入頁
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer integer = (Integer) request.getSession().getAttribute("uid");
        if(integer != null){
            return true;
        }
        response.sendRedirect("/web/login.html");
        return false;
    }
}
