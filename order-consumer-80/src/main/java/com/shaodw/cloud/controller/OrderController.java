package com.shaodw.cloud.controller;

import com.shaodw.cloud.domain.CommonResult;
import com.shaodw.cloud.domain.Payment;
import com.shaodw.cloud.loadbalance.MyLoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author shaodw
 * @date 2021/3/22 20:50
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

//    private final String provider_path = "http://localhost:8001";
    private final String provider_path = "http://PAYMENT-PROVIDER";

    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody Payment payment){
        return restTemplate.postForObject(provider_path + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/getById/{id}")
    public CommonResult<String> getById(@PathVariable("id") Long id){
        return restTemplate.getForObject(provider_path + "/payment/getById/" + id,  CommonResult.class);
    }

    @GetMapping("/getForEntityById/{id}")
    public CommonResult<String> getForEntityById(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(provider_path + "/payment/getById/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else return new CommonResult<>(444, "操作失败");
    }

    //使用自定义的负载均衡
    @Autowired
    private MyLoadBalance myLoadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/lb/{id}")
    public String getPaymentLB(@PathVariable("id") String id)
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-PROVIDER");

        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = myLoadBalance.getInstance(instances);
        URI uri = serviceInstance.getUri();

        System.out.println(uri.toString());
        return restTemplate.getForObject(uri+"/payment/getById/" + id,String.class);

    }
}
