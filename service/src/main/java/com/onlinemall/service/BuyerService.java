package com.onlinemall.service;

import com.onlinemall.mybatis_entity.Buyer;
import com.onlinemall.req.BuyerReq;

public interface BuyerService {
    /**
     * 用户注册
     *
     * @param buyerReq
     * @return
     */
    Integer buyerRegister(BuyerReq buyerReq);

    /**
     * 根据登录名查询用户
     *
     * @param loginName
     * @return
     */
    Buyer findByLoginName(String loginName);
}
