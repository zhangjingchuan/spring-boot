package com.mangmangbang.springbootautoconfig.bootstrap;

import com.mangmangbang.springbootautoconfig.service.CalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * 条件配置Profile方式 演示示例
 * created by zhangjingchuan on 2019/8/1
 */
@SpringBootApplication(scanBasePackages = "com.mangmangbang.springbootautoconfig.service")
public class CalculateServiceBootstrap {

    private static Logger logger = LoggerFactory.getLogger(ReopsitoryBootstrap.class);

    public static void main(String [] args){
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);

        CalculateService calculateService = context.getBean(CalculateService.class);

        logger.info("calculateService.sum(1,2,3,4,5,6,7,8,9,10):"+calculateService.sum(1,2,3,4,5,6,7,8,9,10));
        context.close();

    }
}
