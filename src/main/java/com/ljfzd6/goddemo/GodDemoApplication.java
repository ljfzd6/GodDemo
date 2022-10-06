package com.ljfzd6.goddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ljfzd6.goddemo.mapper")
public class GodDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GodDemoApplication.class, args);
    }
}


