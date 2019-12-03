package com.mangmangbang.springbootautoconfig.configuration;

import com.mangmangbang.springbootautoconfig.annotation.EnableHelloWorld;
import com.mangmangbang.springbootautoconfig.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * created by zhangjingchuan on 2019/8/1
 */
@Configuration
@EnableHelloWorld
@ConditionalOnSystemProperty(name = "user.name",value = "zhangjingchuan")
public class HelloWorldAutoConfiguration {
}
