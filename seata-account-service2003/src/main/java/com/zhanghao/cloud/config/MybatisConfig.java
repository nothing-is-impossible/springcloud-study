package com.zhanghao.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhang hao on 2021/6/15
 */
@Configuration
@MapperScan("com.zhanghao.cloud.dao")
public class MybatisConfig {
}
