package com.zhanghao.cloud.service;

import com.zhanghao.springcloud.entity.CommonResult;
import com.zhanghao.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhang hao on 2021/6/14
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
