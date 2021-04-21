package com.shaodw.cloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author shaodw
 * @date 2021/3/30 10:16
 * @description
 */
public interface LoadBalance {
    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);
}
