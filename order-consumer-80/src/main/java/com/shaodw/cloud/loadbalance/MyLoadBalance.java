package com.shaodw.cloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shaodw
 * @date 2021/3/30 10:18
 * @description
 */
@Component
public class MyLoadBalance implements LoadBalance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    private int getAndIncrement() {
        int cur;
        int next;
        do {
            cur = atomicInteger.get();
            next = cur == Integer.MAX_VALUE ? 0 : cur + 1;
        }while (!this.atomicInteger.compareAndSet(cur, next));
        System.out.println("*****第几次访问，次数next: "+next);
        return next;
    }
}
