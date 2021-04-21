package com.shaodw.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shaodw
 * @date 2021/3/29 10:36
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkApplication80.class);
    }
}
