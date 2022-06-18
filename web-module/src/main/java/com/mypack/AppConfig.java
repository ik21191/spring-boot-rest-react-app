package com.mypack;

import com.mypack.service.MyService;
import com.mypack.service.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MyService getMyService() {
        System.out.println("Creating MyService bean....");
        return new MyServiceImpl();
    }
}
