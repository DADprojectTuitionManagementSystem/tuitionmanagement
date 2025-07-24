package com.tuition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/tms-login.html",
                    "/tms-student-dashboard.html",
                    "/tms-tutor-dashboard.html",
                    "/api/auth/**", 
                    "/api/classes/**",
                    "/api/payments/**",
                    "/css/**", 
                    "/js/**",
                    "/images/**"
                ).permitAll()
                .anyRequest().permitAll()
          )
          .formLogin(form -> form.disable())
          .httpBasic(httpBasic -> httpBasic.disable());
        return http.build();
    }
}



