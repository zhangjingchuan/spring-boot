package com.youxuewen.orderclient.controller;

import com.youxuewen.orderclient.client.ProductClient;
import com.youxuewen.orderclient.dto.CartDTO;
import com.youxuewen.orderclient.pojo.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;


    @GetMapping("/getProductMsg")
    public String getProductMsg(){

        String response = this.productClient.productMsg();
        log.info("response={}",response);

        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> productInfos = this.productClient.listForOrder(Arrays.asList("157875196366160022"));

        log.info("response={}",productInfos);
        return "ok";
    }

    @GetMapping("/decreaseStock")
    public String decreaseStock(){

        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId("164103465734242707");
        cartDTO.setProductQuantity(3);

        this.productClient.decreaseStock(Arrays.asList(cartDTO));

        return "ok";
    }
}
