package com.youxuewen.orderclient.repository;

import com.youxuewen.orderclient.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by zhangjingchuan on 2019/12/24
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
