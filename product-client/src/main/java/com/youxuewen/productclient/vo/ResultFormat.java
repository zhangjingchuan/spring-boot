package com.youxuewen.productclient.vo;

import lombok.Data;

/**
 *
 * http请求返回的数据格式封装
 * created by zhangjingchuan on 2019/12/23
 */
@Data
public class ResultFormat {

    private Integer code;
    private String msg;
    private Object data;
}
