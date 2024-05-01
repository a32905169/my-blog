package com.example.blog.config;

import com.example.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chang
 * @create 2024-04-2024/4/26 下午 05:43
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //註冊管理登入會話之攔截器與指定相關白名單
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/users/login");
        excludePath.add("/users/register");
        excludePath.add("/web/login.html");
        excludePath.add("/web/register.html");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
    }

    /**
     * 指定頭像資源存放之路徑
     * 以對應URL為/images/**之請求
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///C:/WorkSpaceIDEA/web-all/blog/src/main/resources/static/images/");
    }
}
