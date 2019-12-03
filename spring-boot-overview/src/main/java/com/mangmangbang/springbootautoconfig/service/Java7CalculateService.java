package com.mangmangbang.springbootautoconfig.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * java7 for循环实现
 * created by zhangjingchuan on 2019/8/1
 */
@Profile("java7")
@Service
public class Java7CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... value) {

        int sum = 0;

        for(int i=0;i<value.length;i++){
            sum+=value[i];
        }
        return sum;
    }

    public static void main(String [] args){
        CalculateService service = new Java7CalculateService();
        Integer sum = service.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sum);
    }
}
