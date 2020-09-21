package com.yujian.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Spring01Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring01Application.class, args);
    }

}
