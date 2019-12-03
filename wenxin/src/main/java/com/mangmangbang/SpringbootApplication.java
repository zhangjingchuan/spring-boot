package com.mangmangbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.mangmangbang.dao")
@ComponentScan({"com.mangmangbang","org.n3r.idworker"})
public class SpringbootApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringbootApplication.class, args);
    }

}