package com.shaodw.cloud.controller;

import com.shaodw.cloud.domain.CommonResult;
import com.shaodw.cloud.domain.Payment;
import com.shaodw.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shaodw
 * @date 2021/3/22 20:02
 * @description
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/add")
    public CommonResult<Boolean> add(@RequestBody Payment payment)
    {
        boolean add = paymentService.add(payment);
        return CommonResult.<Boolean>builder()
                .code(200)
                .message("这是端口为: " + port + " 的进程提供的服务")
                .data(add)
                .build();
    }

    @GetMapping("/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        return CommonResult.<Payment>builder()
                .code(200)
                .message("这是端口为: " + port + " 的进程提供的服务")
                .data(paymentService.getById(id))
                .build();
    }

    //对于注册进eureka的服务 可以通过服务发现来获得该服务的信息
    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/discovery")
    public Object discovery(){
        discoveryClient.getServices().forEach(System.out::println); //这个微服务的多个
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-PROVIDER");
        instances.forEach(serviceInstance -> {
            System.out.println(serviceInstance.getServiceId() + "\t"
            + serviceInstance.getHost() + "\t" + serviceInstance.getMetadata());
        });

        return this.discoveryClient;
    }

    @GetMapping("/timeout")
    public String timeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }return port + "超时完成";
    }

}
