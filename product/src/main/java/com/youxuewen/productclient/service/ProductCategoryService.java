package com.youxuewen.productclient.service;

import com.youxuewen.productclient.pojo.ProductCategory;

import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/23
 */
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
