package com.shaodw.cloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author shaodw
 * @date 2021/3/30 10:38
 * @description
 */
@SpringBootApplication
@EnableFeignClients
public class Feign80 {

    public static void main(String[] args) {
        SpringApplication.run(Feign80.class);
    }

    //开启Feign日志bean
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
