package com.zhanghao.cloud.controller;

import com.zhanghao.springcloud.entity.CommonResult;
import com.zhanghao.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zhang hao on 2021/6/14
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> map = new HashMap();
    static {
        map.put(1L, new Payment(1L, "123456789"));
        map.put(2L, new Payment(2L, "223456789"));
        map.put(3L, new Payment(3L, "323456789"));
    }

    @GetMapping("/paymentSql/{id}")
    public CommonResult paymentSql(@PathVariable(value = "id")Long id) {
        CommonResult result = new CommonResult(200, "from mysql:" + serverPort, map.get(id));
        return result;
    }
}
