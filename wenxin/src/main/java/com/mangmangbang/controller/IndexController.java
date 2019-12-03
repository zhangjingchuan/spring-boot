package com.mangmangbang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by zhangjingchuan on 2019/10/11
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/hello")
    public String hell(){
        return "hello index";
    }
}
