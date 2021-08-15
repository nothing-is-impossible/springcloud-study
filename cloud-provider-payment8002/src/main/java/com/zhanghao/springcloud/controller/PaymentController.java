package com.zhanghao.springcloud.controller;

import com.zhanghao.springcloud.entity.CommonResult;
import com.zhanghao.springcloud.entity.Payment;
import com.zhanghao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author zhang hao on 2021/5/19
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult creat(@RequestBody Payment payment) {
        int reslut = paymentService.creatPayment(payment);
        log.info("结果为：" + reslut);
        if (reslut > 0) {
            return new CommonResult(200, "插入成功" + serverPort, reslut);
        }else {
            return new CommonResult(444, "插入失败", 0);
        }
    }



    @GetMapping("/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("结果为：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功" + serverPort, payment);
        }else {
            return new CommonResult(444, "查询失败");
        }
    }

    @GetMapping("/payment/lb")
    public String LB() {
        return serverPort;
    }

    @GetMapping("/payment/timeout")
    public String timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "openFeign超时测试";
    }
}
