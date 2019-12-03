package com.mangmangbang.lambda;

import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by zhangjingchuan on 2019/11/4
 */
public class LambdaTest {

    @Test
    public void test01(){
        String queryString = "key=1&id=123&name=zhangsan&pageNo=1&pageSize=10";


        Map<String, String> collect = Stream.of(queryString.split("&")).map(s -> s.split("=")).collect(Collectors.toMap(array -> array[0], array -> array[1]));

        System.out.println(collect);
    }

}
