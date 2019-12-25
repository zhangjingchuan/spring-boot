package com.youxuewen.orderclient.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@Getter
@AllArgsConstructor
public enum  ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
    ;

    private Integer code;
    private String message;
}
