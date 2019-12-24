package com.youxuewen.orderclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //1.第一种方式(直接使用restTemplate，url写死)
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/server/msg", String.class);
//        log.info("response={}",response);

        //2.第二种方式(利用LoadBalancerClient通过应用名获取url及端口，然后再使用restTemplate)
//        ServiceInstance serviceInstance = this.loadBalancerClient.choose("PRODUCT-CLIENT");
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//
//        String url = String.format("http://%s:%s",host,port+"/server/msg");
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);

        //3.第三种
        String response = restTemplate.getForObject("http://PRODUCT-CLIENT/server/msg", String.class);
        return response;
    }
}
