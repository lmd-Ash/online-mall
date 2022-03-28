package com.onlinemall.service;

import com.onlinemall.req.OrderReq;
import com.onlinemall.resp.BuyerResp;
import com.onlinemall.resp.OrderResp;

import java.util.List;

public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderReq
     * @return
     */
    Integer createOrder(OrderReq orderReq, BuyerResp buyerResp);

    /**
     * 查询订单
     *
     * @param orderReq
     * @return
     */
    List<OrderResp> findAllByBuyerId(OrderReq orderReq);

    /**
     * 查询订单
     *
     * @param orderReq
     * @return
     */
    List<OrderResp> findAll(OrderReq orderReq);
}
