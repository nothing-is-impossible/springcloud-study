package com.zhanghao.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhanghao.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhang hao on 2021/6/4
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "paymentInfo_global_TimeoutHandler") //全局异常定位方法
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.paymentInfo_OK(id);
        log.info(s);
        return s;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    }) //用于解决服务降级,出错会用paymentInfo_TimeoutHandler方法
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.paymentInfo_Timeout(id);
        log.info(s);
        return s;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "我是消费者80，等太久了，不想等了";
    }

    public String paymentInfo_global_TimeoutHandler() {
        return "全局配置来喽！";
    }
}
