package com.mangmangbang.springbootautoconfig.service;

/**
 *
 * 计算服务，条件配置示例
 * created by zhangjingchuan on 2019/8/1
 */
public interface CalculateService {

    /**
     * 多个证书sum求和
     * @param value
     * @return
     */
    Integer sum(Integer... value);
}
