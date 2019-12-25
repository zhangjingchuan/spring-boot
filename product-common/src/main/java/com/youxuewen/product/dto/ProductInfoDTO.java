package com.youxuewen.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


/**
 * created by zhangjingchuan on 2019/12/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDTO {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

}
