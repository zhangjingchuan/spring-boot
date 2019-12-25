package com.youxuewen.productclient.exception;

import com.youxuewen.productclient.enums.ResultEnum;

/**
 * created by zhangjingchuan on 2019/12/25
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
