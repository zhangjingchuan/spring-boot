package com.youxuewen.productclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by zhangjingchuan on 2019/12/23
 */
@RestController
@RequestMapping("/product")
public class ProductController {



    @GetMapping("/list")
    public  void list(){

    }
}
