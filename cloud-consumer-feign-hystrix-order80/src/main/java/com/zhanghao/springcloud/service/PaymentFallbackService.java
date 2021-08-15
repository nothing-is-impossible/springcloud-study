package com.zhanghao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zhang hao on 2021/6/5
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "全局ok方法异常了";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "全局timeout方法异常了";
    }
}
