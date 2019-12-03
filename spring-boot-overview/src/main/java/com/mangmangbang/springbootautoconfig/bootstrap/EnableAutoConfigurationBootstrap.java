package com.mangmangbang.springbootautoconfig.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * EnableAutoConfiguratio 引导类
 * created by zhangjingchuan on 2019/8/1
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    private static Logger logger = LoggerFactory.getLogger(ReopsitoryBootstrap.class);

    public static void main(String [] args){
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);

        String helloWorld = context.getBean("helloWorld",String.class);
        logger.info("EnableAutoConfigurationBootstrap run : "+helloWorld);
        context.close();

    }
}
