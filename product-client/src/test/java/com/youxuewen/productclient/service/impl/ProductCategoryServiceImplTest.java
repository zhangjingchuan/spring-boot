package com.youxuewen.productclient.service.impl;

import com.youxuewen.productclient.pojo.ProductCategory;
import com.youxuewen.productclient.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Resource
    private ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> list = this.productCategoryService.findByCategoryTypeIn(Arrays.asList(11,12));
        Assert.assertTrue(list.size()>0);
    }
}