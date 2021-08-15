package com.zhanghao.cloud.service.impl;

import com.zhanghao.cloud.dao.OrderDao;
import com.zhanghao.cloud.domain.Order;
import com.zhanghao.cloud.service.AccountService;
import com.zhanghao.cloud.service.OrderService;
import com.zhanghao.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhang hao on 2021/6/15
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp_create_order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("~~~~~~~~~~~开始新建订单");
        orderDao.create(order);

        log.info("~~~~~~~~~~~订单微服务调用库存做扣减");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("~~~~~~~~~~~账户余额做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("~~~~~~~~~~~修改订单状态");
        orderDao.update(order.getUserId(), 0);

        log.info("~~~~~~~~~~~下订单结束了");


    }
}
