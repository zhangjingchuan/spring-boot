package com.youxuewen.orderclient.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youxuewen.orderclient.dto.OrderDTO;
import com.youxuewen.orderclient.enums.ResultEnum;
import com.youxuewen.orderclient.exception.OrderException;
import com.youxuewen.orderclient.form.OrderForm;
import com.youxuewen.orderclient.pojo.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@Slf4j
public class OrderForm2OrderDtoConverter {

    public static OrderDTO convert(OrderForm orderForm){

        List<OrderDetail> orderDetailList = new ArrayList<>();

        Gson gson = new Gson();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("[json转换]错误，string={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);

        }

        OrderDTO orderDTO = OrderDTO.builder()
                .buyerName(orderForm.getName())
                .buyerPhone(orderForm.getPhone())
                .buyerAddress(orderForm.getAddress())
                .buyerOpenid(orderForm.getOpenid())
                .orderDetailList(orderDetailList)
                .build();


        return orderDTO;
    }
}
