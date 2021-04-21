package com.shaodw.cloud.controller;

import com.shaodw.cloud.domain.CommonResult;
import com.shaodw.cloud.domain.Payment;
import com.shaodw.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author shaodw
 * @date 2021/3/30 10:43
 * @description 以前使用resttemplate调用 现在就像是调service层方法一样
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource PaymentService paymentService;

    @GetMapping("/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id){
        CommonResult<Payment> byId = paymentService.getById(id);
        System.out.println(byId);
        return byId;
    }

    @PostMapping(value = "/add")
    public CommonResult<Boolean> add(@RequestBody Payment payment){
        return paymentService.add(payment);
    }

    @GetMapping("/timeout")
    public void timeOut(){
        System.out.println(paymentService.timeOut());
    }
}
