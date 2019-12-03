package com.mangmangbang.springbootautoconfig.bootstrap;

import com.mangmangbang.springbootautoconfig.annotation.EnableHelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * (@link EnableHelloWorld) 引导类
 * created by zhangjingchuan on 2019/8/1
 */
@EnableHelloWorld
public class EnableHelloWorldBootStrap {

    private static Logger logger = LoggerFactory.getLogger(EnableHelloWorld.class);


    public static void main(String [] args){

        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String hello= context.getBean("helloWorld", String.class);

        logger.info("hello World run:" + hello);

        context.close();
    }
}
