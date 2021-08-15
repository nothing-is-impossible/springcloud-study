package com.zhanghao.cloud.service;

import java.math.BigDecimal;

/**
 * @author zhang hao on 2021/6/15
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
