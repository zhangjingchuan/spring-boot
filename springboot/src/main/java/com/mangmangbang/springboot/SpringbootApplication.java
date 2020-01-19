package com.mangmangbang.springboot;

import com.mangmangbang.springboot.initlallzer.SecondInitlallzer;
import com.mangmangbang.springboot.initlallzer.ThirdInitlallzer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootApplication.class, args);
        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
        springApplication.addInitializers(new SecondInitlallzer());
        springApplication.run(args);
    }

}
