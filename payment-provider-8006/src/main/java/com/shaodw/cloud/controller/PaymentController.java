package com.shaodw.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author shaodw
 * @date 2021/3/29 11:06
 * @description
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    public String port;

    @GetMapping("/test")
    public String test(){
        return "springcloud with consul " + port + " => " + UUID.randomUUID().toString();
    }
}
