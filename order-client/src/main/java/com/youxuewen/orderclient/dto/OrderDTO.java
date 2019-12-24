package com.youxuewen.orderclient.dto;

import com.youxuewen.orderclient.pojo.OrderDetail;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@Data
@Builder
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private int orderStatus;

    private int payStatus;

    private List<OrderDetail> orderDetailList;
}
