package com.youxuewen.productclient.service.impl;

import com.youxuewen.productclient.pojo.ProductInfo;
import com.youxuewen.productclient.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
}