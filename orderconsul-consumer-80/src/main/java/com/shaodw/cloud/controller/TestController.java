package com.shaodw.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author shaodw
 * @date 2021/3/29 13:51
 * @description
 */
@RestController
@Configuration
public class TestController {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
     return new RestTemplate();
    }

    private @Resource RestTemplate restTemplate;

    private final String invokeUrl = "http://provider-consul";

    @GetMapping("/testConusl")
    public String test(){
        String s = restTemplate.getForObject(invokeUrl + "/test", String.class);
        System.out.println(s);
        return s;
    }
}
