package com.youxuewen.orderclient.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@Getter
@AllArgsConstructor
public enum PayStatusEnum {

    WAIT(0,"待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;
    private String message;
}
