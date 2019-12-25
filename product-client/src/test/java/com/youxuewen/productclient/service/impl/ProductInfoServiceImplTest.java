package com.youxuewen.productclient.service.impl;

import com.youxuewen.productclient.dto.CartDTO;
import com.youxuewen.productclient.pojo.ProductInfo;
import com.youxuewen.productclient.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * created by zhangjingchuan on 2019/12/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Resource
    private ProductInfoService productInfoService;

    @Test
    public void findUpAll() {

        List<ProductInfo> upAll = this.productInfoService.findUpAll();
        Assert.assertTrue(upAll.size()>0);

    }

    @Test
    public void findByProductIdIn() {

        List<String> ids = new ArrayList<>();
        ids.add("157875196366160022");
        ids.add("164103465734242707");
        List<ProductInfo> list = this.productInfoService.findByProductIdIn(ids);
        Assert.assertTrue(list.size()==2);
    }

    @Test
    public void decreaseStock() {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId("157875196366160022");
        cartDTO.setProductQuantity(2);

        this.productInfoService.decreaseStock(Arrays.asList(cartDTO));
    }
}