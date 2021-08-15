package com.zhanghao.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang hao on 2021/5/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long id;

    private String serial;
}
