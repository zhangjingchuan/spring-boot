package com.mangmangbang.ajaxserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by zhangjingchuan on 2020/1/13
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get1")
    private ResultBean get1(){
        System.out.println("TestController.get1()");

        return new ResultBean("get1 ok");
    }
}
