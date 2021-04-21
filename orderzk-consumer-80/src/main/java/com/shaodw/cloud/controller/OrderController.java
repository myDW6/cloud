package com.shaodw.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shaodw
 * @date 2021/3/29 10:38
 * @description
 */
@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    private final String invokeUrl = "http://payment-provider"; //zookeeper上的服务名

    //通过zookeeper去调用服务提供者的服务
    @GetMapping("/orderzk")
    public String getByZookeeper(){
        String result = restTemplate.getForObject(invokeUrl + "/payment/zk", String.class);
        System.out.println(result);
        return result;
    }
}
