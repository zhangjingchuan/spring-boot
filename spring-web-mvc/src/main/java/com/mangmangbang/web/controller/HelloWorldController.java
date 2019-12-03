package com.mangmangbang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * helloWorld controller
 * created by zhangjingchuan on 2019/8/5
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(){
        return "index";
    }
}
