package com.youxuewen.orderclient.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private int orderStatus;

    private int payStatus;

    private Date createTime;

    private Date updateTime;
}
