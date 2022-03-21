package com.onlinemall.service;

import com.onlinemall.mybatis_entity.OrderDetail;

public interface OrderDetailService {
    /**
     * 保存订单详情
     *
     * @param orderDetail
     * @return
     */
    OrderDetail save(OrderDetail orderDetail);
}
