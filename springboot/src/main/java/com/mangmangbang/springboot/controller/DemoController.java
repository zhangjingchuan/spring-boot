package com.mangmangbang.springboot.controller;

import com.mangmangbang.springboot.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by zhangjingchuan on 2020/1/15
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        return this.testService.test();
    }
}
