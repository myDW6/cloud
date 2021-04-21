package com.shaodw.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author shaodw
 * @date 2021/3/29 10:22
 * @description
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    public String paymentZk(){
        return "you received from zookerpaper " + port + " => " + UUID.randomUUID().toString();
    }
}
