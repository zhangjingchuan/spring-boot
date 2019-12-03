package com.mangmangbang.springbootautoconfig.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * created by zhangjingchuan on 2019/8/1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import(HelloWorldConfiguration.class)class
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {

}
