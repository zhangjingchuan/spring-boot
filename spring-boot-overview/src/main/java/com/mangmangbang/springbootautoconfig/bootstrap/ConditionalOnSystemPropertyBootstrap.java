package com.mangmangbang.springbootautoconfig.bootstrap;

import com.mangmangbang.springbootautoconfig.condition.ConditionalOnSystemProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 * 系统属性条件引导类
 * created by zhangjingchuan on 2019/8/1
 */
public class ConditionalOnSystemPropertyBootstrap {

    private static Logger logger = LoggerFactory.getLogger(ReopsitoryBootstrap.class);

    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "zhangjingchuan")
    public String helloWorld(){
        return "hello ,world 章三";
    }

    public static void main(String [] args){
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld",String.class);

        logger.info("helloWorld Bean:"+helloWorld );


        context.close();

    }
}
