package com.youxuewen.productclient.service.impl;

import com.youxuewen.productclient.enums.ProductStatusEnum;
import com.youxuewen.productclient.pojo.ProductInfo;
import com.youxuewen.productclient.repository.ProductInfoRepository;
import com.youxuewen.productclient.service.ProductInfoService;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/23
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoRepository productInfoRepository;
    @Override
    public List<ProductInfo> findUpAll() {

        ProductInfo productInfo = ProductInfo.builder()
                .productStatus(ProductStatusEnum.UP.getCode())
                .build();
        Example<ProductInfo> example = Example.of(productInfo);
        List<ProductInfo> all = this.productInfoRepository.findAll(example);
        return all;
    }
}
