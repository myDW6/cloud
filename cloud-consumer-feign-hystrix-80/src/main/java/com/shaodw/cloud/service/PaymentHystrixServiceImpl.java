package com.shaodw.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author shaodw
 * @date 2021/3/31 09:19
 * @description
 */
@Component
public class PaymentHystrixServiceImpl  implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "feign 8001 接口的统一处理方法 paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "feign 8001 接口的统一处理方法 paymentInfo_TimeOut";
    }
}
