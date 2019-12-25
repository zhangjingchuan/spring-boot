package com.youxuewen.orderclient.client;

import com.youxuewen.orderclient.dto.CartDTO;
import com.youxuewen.orderclient.pojo.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/25
 */
@FeignClient(name = "PRODUCT-CLIENT")
@Component
public interface ProductClient {

    @GetMapping("/server/msg")
    String productMsg();


    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
