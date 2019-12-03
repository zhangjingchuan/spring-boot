package com.mangmangbang.springbootautoconfig.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 *
 * java8 lambda实现
 * created by zhangjingchuan on 2019/8/1
 */
@Profile("java8")
@Service
public class Java8CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... value) {

        int sum = Stream.of(value).reduce(0,Integer::sum);
        return sum;
    }

    public static void main(String [] args){
        CalculateService service = new Java8CalculateService();
        Integer sum = service.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sum);
    }
}
