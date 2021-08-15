package com.zhanghao.springcloud.service.impl;

import com.zhanghao.springcloud.dao.PaymentDao;
import com.zhanghao.springcloud.entity.Payment;
import com.zhanghao.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author zhang hao on 2021/5/19
 */
@Service
public class PaymentServiceImpl  implements PaymentService {

    @Autowired
    @Qualifier("paymentDao")
    private PaymentDao paymentDao;

    @Override
    public int creatPayment(Payment payment) {
        return paymentDao.creatPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
