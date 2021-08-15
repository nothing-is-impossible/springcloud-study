package com.zhanghao.cloud.service;

import com.zhanghao.cloud.domain.CommonResult;

/**
 * @author zhang hao on 2021/6/15
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
