package com.mangmangbang.springbootautoconfig.bootstrap;

import com.mangmangbang.springbootautoconfig.repository.MyFirstLevelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * created by zhangjingchuan on 2019/8/1
 */
@ComponentScan("com.mangmangbang.springbootautoconfig.repository")
public class ReopsitoryBootstrap {

    private static Logger logger = LoggerFactory.getLogger(ReopsitoryBootstrap.class);

    public static void main(String [] args){
        ConfigurableApplicationContext context = new SpringApplicationBuilder(MyFirstLevelRepository.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MyFirstLevelRepository myFristLevelRepository = context.getBean("myFristLevelRepository",MyFirstLevelRepository.class);

        logger.info("myFristLevelRepository rum : " + myFristLevelRepository.toString());

        context.close();

    }
}
