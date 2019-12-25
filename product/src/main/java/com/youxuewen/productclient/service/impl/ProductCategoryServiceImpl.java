package com.youxuewen.productclient.service.impl;

import com.youxuewen.productclient.pojo.ProductCategory;
import com.youxuewen.productclient.repository.ProductCategoryRepository;
import com.youxuewen.productclient.service.ProductCategoryService;
import javafx.scene.paint.Material;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/23
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {

        Specification<ProductCategory> specification = new Specification<ProductCategory>() {

            @Override
            public Predicate toPredicate(Root<ProductCategory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = root.get("categoryType").as(Integer.class).in(categoryTypeList);
                return predicate;
            }
        };

        return productCategoryRepository.findAll(specification);
    }
}
