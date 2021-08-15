package com.zhanghao.cloud.service.impl;

import com.zhanghao.cloud.dao.AccountDao;
import com.zhanghao.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author zhang hao on 2021/6/15
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {

//        造个超时异常
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("~~~~~~~~~~~~~账户开始减少余额");
        accountDao.decrease(userId, money);
    }
}
