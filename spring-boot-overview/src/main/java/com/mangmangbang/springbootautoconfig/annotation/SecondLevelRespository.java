package com.mangmangbang.springbootautoconfig.annotation;

import java.lang.annotation.*;

/**
 * created by zhangjingchuan on 2019/8/1
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRespository {
    String value() default "";
}
