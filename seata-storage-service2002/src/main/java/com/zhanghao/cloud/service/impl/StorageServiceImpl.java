package com.zhanghao.cloud.service.impl;

import com.zhanghao.cloud.dao.StorageDao;
import com.zhanghao.cloud.domain.CommonResult;
import com.zhanghao.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang hao on 2021/6/15
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("~~~~~~~~~~从storage中减少库存");
        storageDao.decrease(productId, count);
    }
}
