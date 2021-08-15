package com.zhanghao.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhang hao on 2021/6/1
 */
@RestController
public class OrderConsulController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://consul-privider-payment";

    @GetMapping("/consumers/payment/consul")
    public String paymentInfo() {
        String s = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return s;
    }
}
