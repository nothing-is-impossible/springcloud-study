package com.zhanghao.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhanghao.springcloud.entity.CommonResult;
import com.zhanghao.springcloud.entity.Payment;

/**
 * @author zhang hao on 2021/6/14
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException blockException) {
        return new CommonResult(444, "按用户自定义全局限流测试1", new Payment(2021L, "serial03"));
    }

    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(444, "按用户自定义全局限流测试2", new Payment(2021L, "serial03"));
    }
}
