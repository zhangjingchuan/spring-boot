package com.youxuewen.orderclient.controller;

import com.youxuewen.orderclient.converter.OrderForm2OrderDtoConverter;
import com.youxuewen.orderclient.dto.OrderDTO;
import com.youxuewen.orderclient.enums.ResultEnum;
import com.youxuewen.orderclient.exception.OrderException;
import com.youxuewen.orderclient.form.OrderForm;
import com.youxuewen.orderclient.pojo.OrderDetail;
import com.youxuewen.orderclient.service.OrderService;
import com.youxuewen.orderclient.vo.ResultFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @return
     */
    @PostMapping("/create")
    public ResultFormat create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[创建订单]参数不正确，orderForm={}",orderForm);
            throw  new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        //将orderForm 转换成 orderDto
        OrderDTO orderDTO = OrderForm2OrderDtoConverter.convert(orderForm);

        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        if(CollectionUtils.isEmpty(orderDetailList)){
            log.error("[创建订单]购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = this.orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());

        return ResultFormat.success(map);
    }
}
