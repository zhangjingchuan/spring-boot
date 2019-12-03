package com.mangmangbang.springbootautoconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * HelloWOrld配置
 * created by zhangjingchuan on 2019/8/1
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){//方法名即为bean的名称
        return "hello world";
    }
}
