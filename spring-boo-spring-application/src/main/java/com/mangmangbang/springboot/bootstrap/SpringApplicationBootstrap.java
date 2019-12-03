package com.mangmangbang.springboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * springApplication 引导类
 * created by zhangjingchuan on 2019/8/2
 */

public class SpringApplicationBootstrap {

    public static void main(String [] args){
        SpringApplication.run(ApplicaitonConfiguration.class,args);
    }

    @SpringBootApplication
    public static class ApplicaitonConfiguration{


    }
}
