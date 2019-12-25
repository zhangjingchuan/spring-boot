package com.youxuewen.productclient.repository;

import com.youxuewen.productclient.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/23
 */
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Integer>,JpaSpecificationExecutor<ProductCategory> {

}
