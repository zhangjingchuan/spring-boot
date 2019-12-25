package com.youxuewen.orderclient.service.impl;

import com.youxuewen.orderclient.client.ProductClient;
import com.youxuewen.orderclient.dto.CartDTO;
import com.youxuewen.orderclient.dto.OrderDTO;
import com.youxuewen.orderclient.enums.OrderStatusEnum;
import com.youxuewen.orderclient.enums.PayStatusEnum;
import com.youxuewen.orderclient.pojo.OrderDetail;
import com.youxuewen.orderclient.pojo.OrderMaster;
import com.youxuewen.orderclient.pojo.ProductInfo;
import com.youxuewen.orderclient.repository.OrderDetailRepository;
import com.youxuewen.orderclient.repository.OrderMasterRepository;
import com.youxuewen.orderclient.service.OrderService;
import com.youxuewen.orderclient.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * created by zhangjingchuan on 2019/12/24
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMasterRepository orderMasterRepository;

    @Resource
    private OrderDetailRepository orderDetailRepository;

    @Resource
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //定义orderId
        String orderId = KeyUtil.genUniqueKey();
        // 查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream().map(orderDetail -> orderDetail.getProductId()).collect(Collectors.toList());
        List<ProductInfo> productInfos = productClient.listForOrder(productIdList);

//        Map<String,ProductInfo> productInfoMap = productInfos.stream().collect(Collectors.toMap(p->p.getProductId(),productInfo -> productInfo));
        //计算总价
        //定义一个总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            String productId = orderDetail.getProductId();
            for(ProductInfo productInfo : productInfos) {

                if(productId.equals(productInfo.getProductId())) {
                    //单价*数量
                    orderAmout = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmout);

                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());

                    //订单详情入库
                    this.orderDetailRepository.save(orderDetail);
                }
            }

//            ProductInfo productInfo = productInfoMap.get(productId);
//            //单价*数量
//            orderAmout = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmout);
//
//            BeanUtils.copyProperties(productInfo,orderDetail);
//            orderDetail.setOrderId(orderId);
//            orderDetail.setDetailId(KeyUtil.genUniqueKey());
        }
        //扣库存(调用商品服务）
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(orderDetail -> new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        //订单入库
        OrderMaster orderMaster = OrderMaster.builder().build();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        this.orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
