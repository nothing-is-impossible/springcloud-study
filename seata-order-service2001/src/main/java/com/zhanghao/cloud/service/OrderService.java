package com.zhanghao.cloud.service;

import com.zhanghao.cloud.domain.Order;
import org.aspectj.weaver.ast.Or;

/**
 * @author zhang hao on 2021/6/15
 */
public interface OrderService {
    void create(Order order);
}
