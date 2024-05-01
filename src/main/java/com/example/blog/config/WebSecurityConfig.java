package com.example.blog.config;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * 單純是因為要使用BCryptPasswordEncoder時必須導入Spring Security(我配置後就沒報錯了)
 * 才進行Spring Security註冊與配置
 * 但因為主要使用session進行登入狀態會話管理
 * 所以這個securityFilter基本上沒用
 *
 * @author chang
 * @create 2024-04-2024/4/26 下午 05:49
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((authorize) -> authorize
                            .anyRequest().permitAll()
                    )
                    .formLogin((form) -> form
                            .loginPage("/")      //禁用Security預設登入頁面
                            .permitAll()
                    )
                    .csrf(AbstractHttpConfigurer::disable)  //禁用csrf保護，因為會導致post發送不到控制器
                    .httpBasic(withDefaults()); // 使用默認配置啟用 HTTP Basic 認證

            return http.build();
        }
    }
}
