package com.zhanghao.cloud.dao;

import com.zhanghao.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhang hao on 2021/6/15
 */
@Mapper
public interface OrderDao {
//    新建订单
    void create(Order order);

//    修改订单状态
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
