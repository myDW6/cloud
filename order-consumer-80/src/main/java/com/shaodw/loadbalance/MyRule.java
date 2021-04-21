package com.shaodw.loadbalance;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shaodw
 * @date 2021/3/30 09:50
 * @description
 */
@Configuration
public class MyRule {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
