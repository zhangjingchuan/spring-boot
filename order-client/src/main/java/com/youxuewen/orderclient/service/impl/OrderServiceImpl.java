package com.youxuewen.orderclient.service.impl;

import com.youxuewen.orderclient.dto.OrderDTO;
import com.youxuewen.orderclient.enums.OrderStatusEnum;
import com.youxuewen.orderclient.enums.PayStatusEnum;
import com.youxuewen.orderclient.pojo.OrderDetail;
import com.youxuewen.orderclient.pojo.OrderMaster;
import com.youxuewen.orderclient.repository.OrderDetailRepository;
import com.youxuewen.orderclient.repository.OrderMasterRepository;
import com.youxuewen.orderclient.service.OrderService;
import com.youxuewen.orderclient.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMasterRepository orderMasterRepository;

    @Resource
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //TODO 查询商品信息（调用商品服务）
        //TODO 计算总价
        //TODO 口库存(调用商品服务）

        //订单入库
        OrderMaster orderMaster = OrderMaster.builder().build();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        this.orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
