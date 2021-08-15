package com.zhanghao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zh
 * zhang hao on 2021/6/1
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableDiscoveryClient用于向zookeeper或者consul中注册服务
public class ConsulOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain80.class, args);
    }
}
