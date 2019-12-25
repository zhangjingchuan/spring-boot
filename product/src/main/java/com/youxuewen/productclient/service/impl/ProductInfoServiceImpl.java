package com.youxuewen.productclient.service.impl;

import com.youxuewen.productclient.dto.CartDTO;
import com.youxuewen.productclient.enums.ProductStatusEnum;
import com.youxuewen.productclient.enums.ResultEnum;
import com.youxuewen.productclient.exception.ProductException;
import com.youxuewen.productclient.pojo.ProductCategory;
import com.youxuewen.productclient.pojo.ProductInfo;
import com.youxuewen.productclient.repository.ProductInfoRepository;
import com.youxuewen.productclient.service.ProductInfoService;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductInfo> findByProductIdIn(List<String> productIdList) {
//        Specification<ProductInfo> specification = new Specification<ProductInfo>() {
//
//            @Override
//            public Predicate toPredicate(Root<ProductInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                Predicate predicate = root.get("productId").as(String.class).in(productIdList);
//                return predicate;
//            }
//        };
//
//        return this.productInfoRepository.findAll(specification);

        return this.productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            //查询商品
            Optional<ProductInfo> productInfoOptional = this.productInfoRepository.findById(cartDTO.getProductId());

            //判断商品是否村子啊
            if(!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //判断商品数量
            ProductInfo productInfo = productInfoOptional.get();
            int count = productInfo.getProductStock() - cartDTO.getProductQuantity();

            if(count<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(count);
            this.productInfoRepository.save(productInfo);
        }
    }
}
