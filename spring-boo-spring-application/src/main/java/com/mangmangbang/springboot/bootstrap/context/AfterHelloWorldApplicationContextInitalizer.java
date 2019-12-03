package com.mangmangbang.springboot.bootstrap.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * created by zhangjingchuan on 2019/8/2
 */
public class AfterHelloWorldApplicationContextInitalizer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C>,Ordered {

    @Override
    public void initialize(C configurableApplicationContext) {
        System.out.println("AfterHelloWorldApplicationContextInitalizer.id="+configurableApplicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
