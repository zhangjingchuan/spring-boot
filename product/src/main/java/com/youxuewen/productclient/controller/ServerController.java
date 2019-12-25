package com.youxuewen.productclient.controller;

import com.youxuewen.productclient.pojo.ProductInfo;
import com.youxuewen.productclient.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/msg")
    public String msg(){
        return "this is product' msg";
    }

}
