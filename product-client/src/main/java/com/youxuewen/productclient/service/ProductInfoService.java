package com.youxuewen.productclient.service;

import com.youxuewen.productclient.pojo.ProductInfo;

import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/23
 */
public interface ProductInfoService {

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();
}
