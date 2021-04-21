package com.shaodw.cloud;

import com.shaodw.loadbalance.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author shaodw
 * @date 2021/3/22 20:48
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "PAYMENT-PROVIDER", configuration = MyRule.class) //MyRole不能被@ComponentScan扫到
public class OrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication80.class, args);
    }

    @Bean
   // @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
