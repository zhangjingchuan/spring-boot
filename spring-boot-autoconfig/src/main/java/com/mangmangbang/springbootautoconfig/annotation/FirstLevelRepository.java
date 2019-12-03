package com.mangmangbang.springbootautoconfig.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * created by zhangjingchuan on 2019/8/1
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface FirstLevelRepository {

    String value() default "";
}
