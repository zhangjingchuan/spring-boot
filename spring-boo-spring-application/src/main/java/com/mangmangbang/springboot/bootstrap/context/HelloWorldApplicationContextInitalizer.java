package com.mangmangbang.springboot.bootstrap.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * created by zhangjingchuan on 2019/8/2
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitalizer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {

    @Override
    public void initialize(C configurableApplicationContext) {
        System.out.println("configurableApplicationContext.id="+configurableApplicationContext.getId());
    }
}
