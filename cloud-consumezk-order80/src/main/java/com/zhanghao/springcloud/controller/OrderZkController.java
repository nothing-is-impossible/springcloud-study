package com.zhanghao.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhang hao on 2021/5/31
 */
@RestController
public class OrderZkController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-privider-payment";

    @GetMapping("/consumers/payment/zk")
    public String paymentInfo() {
        String s = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return s;
    }

}
