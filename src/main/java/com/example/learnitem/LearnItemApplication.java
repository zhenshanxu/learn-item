package com.example.learnitem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.learnitem.mapper")
public class LearnItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnItemApplication.class, args);
    }

}
