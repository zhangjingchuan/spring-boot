package com.mangmangbang.springboot.initlallzer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangjingchuan on 2020/1/15
 */
//第二注入顺序
@Order(2)
public class SecondInitlallzer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        //获得环境
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();

        //自定义属性
        Map<String,Object> map = new HashMap<>();
        map.put("key2","value2");

        //打包属性
        MapPropertySource mapPropertySource = new MapPropertySource("secondInitializer", map);
        //获得所有属性的属性集，并将自定义的属性加入到最后
        environment.getPropertySources().addLast(mapPropertySource);

        System.out.println("run secondInitializer");
    }
}
