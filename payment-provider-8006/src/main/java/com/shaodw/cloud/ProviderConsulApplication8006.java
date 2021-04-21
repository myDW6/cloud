package com.shaodw.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shaodw
 * @date 2021/3/29 11:05
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderConsulApplication8006 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderConsulApplication8006.class);
    }
}
