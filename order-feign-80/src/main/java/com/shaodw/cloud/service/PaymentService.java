package com.shaodw.cloud.service;

import com.shaodw.cloud.domain.CommonResult;
import com.shaodw.cloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author shaodw
 * @date 2021/3/30 10:40
 * @description
 */
@Component
@FeignClient("PAYMENT-PROVIDER")
public interface PaymentService {

    //Feign自带负载均衡配置项

    //调用服务提供者
    @GetMapping("/payment/getById/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);

    @PostMapping(value = "/payment/add")
    CommonResult<Boolean> add(@RequestBody Payment payment);

    //mock timeout
    @GetMapping("/payment/timeout")
    String timeOut();
}
