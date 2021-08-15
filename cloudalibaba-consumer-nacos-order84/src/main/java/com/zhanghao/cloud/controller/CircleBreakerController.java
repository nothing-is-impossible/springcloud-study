package com.zhanghao.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhanghao.cloud.service.PaymentService;
import com.zhanghao.springcloud.entity.CommonResult;
import com.zhanghao.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhang hao on 2021/6/14
 */
@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")//fallback只负责业务异常处理
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")//fallback只负责业务异常处理
    @SentinelResource(value = "blockHandler", blockHandler = "handlerBlock", exceptionsToIgnore = IllegalArgumentException.class, fallback = "handlerFallback")
//blockHandler只负责sentinel的控制台异常违规     exceptionsToIgnore剔除异常
    public CommonResult<Payment> fallBack(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = restTemplate.getForObject(SERVICE_URL + "/paymentSql/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (commonResult.getData() == null) {
            throw new NullPointerException("空指针异常");
        }
        return commonResult;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable throwable) {
        return new CommonResult(444, "定点非全局异常处理" + throwable.getMessage(), new Payment(id, null));
    }

    public CommonResult<Payment> handlerBlock(@PathVariable("id") Long id, BlockException blockException) {
        return new CommonResult(444, "handlerBlock限流处理" + blockException.getMessage(), new Payment(id, null));
    }


//    feign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentService.paymentSql(id);
    }
}
