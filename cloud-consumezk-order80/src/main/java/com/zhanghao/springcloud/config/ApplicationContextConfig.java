package com.zhanghao.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhang hao on 2021/5/31
 */
@Configuration
public class ApplicationContextConfig {

//    @LoadBalanced
//    1,微服务中直接通过名称就可以访问服务    2，负载均衡，轮询
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
