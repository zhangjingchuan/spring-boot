package com.mangmangbang.springbootautoconfig.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 *
 * 条件配置 Condition方式
 * java系统属性条件判断
 * created by zhangjingchuan on 2019/8/1
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional({OnSystemPropertyCondition.class})
public @interface ConditionalOnSystemProperty {

    /**
     * 系统属性名称
     * @return
     */
    String name();

    /**
     * 系统属性值
     * @return
     */
    String value();

}
