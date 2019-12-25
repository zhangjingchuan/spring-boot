package com.youxuewen.orderclient.exception;

import com.youxuewen.orderclient.enums.ResultEnum;

/**
 * created by zhangjingchuan on 2019/12/24
 * 订单一场
 */
public class OrderException extends RuntimeException {

    private Integer code;


    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
