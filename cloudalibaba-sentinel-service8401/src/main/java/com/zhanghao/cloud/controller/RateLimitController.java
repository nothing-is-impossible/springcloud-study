package com.zhanghao.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhanghao.cloud.myhandler.CustomerBlockHandler;
import com.zhanghao.springcloud.entity.CommonResult;
import com.zhanghao.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang hao on 2021/6/13
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试", new Payment(2021L, "serial01"));
    }

    public CommonResult handleException(BlockException blockException) {
        return new CommonResult(444, blockException.getClass().getCanonicalName());
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试", new Payment(2021L, "serial02"));
    }

    @GetMapping("/reteLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按用户自定义限流测试", new Payment(2021L, "serial03"));
    }
}
