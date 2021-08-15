package com.zhanghao.cloud.service;

import com.zhanghao.springcloud.entity.CommonResult;
import com.zhanghao.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author zhang hao on 2021/6/14
 */
@Component
public class PaymentFallBackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444, "服务降级返回");
    }
}
