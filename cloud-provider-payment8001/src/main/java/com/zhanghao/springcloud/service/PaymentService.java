package com.zhanghao.springcloud.service;

import com.zhanghao.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhang hao on 2021/5/19
 */
public interface PaymentService {
    int creatPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
