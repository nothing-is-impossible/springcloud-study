package com.zhanghao.cloud.controller;

import com.zhanghao.cloud.domain.CommonResult;
import com.zhanghao.cloud.domain.Order;
import com.zhanghao.cloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhang hao on 2021/6/15
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
