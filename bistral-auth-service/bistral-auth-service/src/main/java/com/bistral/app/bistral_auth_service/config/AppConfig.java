package com.bistral.app.bistral_auth_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {


    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
