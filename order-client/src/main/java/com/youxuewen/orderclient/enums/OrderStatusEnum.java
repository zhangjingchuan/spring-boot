package com.youxuewen.orderclient.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消")
    ;
    private Integer code;
    private String message;


}
