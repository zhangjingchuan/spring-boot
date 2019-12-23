package com.youxuewen.productclient.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * created by zhangjingchuan on 2019/12/23
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;



}
