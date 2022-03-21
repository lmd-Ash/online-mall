package com.onlinemall.service;

import com.onlinemall.req.OrderReq;
import com.onlinemall.resp.BuyerResp;

public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderReq
     * @return
     */
    Integer createOrder(OrderReq orderReq, BuyerResp buyerResp);
}
