package com.youxuewen.productclient.repository;

import com.youxuewen.productclient.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * created by zhangjingchuan on 2019/12/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Resource
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductIdIn() {

        List<String> ids = new ArrayList<>();
        ids.add("157875196366160022");
        ids.add("164103465734242707");
        List<ProductInfo> list = this.productInfoRepository.findByProductIdIn(ids);
        Assert.assertTrue(list.size()==2);
    }
}