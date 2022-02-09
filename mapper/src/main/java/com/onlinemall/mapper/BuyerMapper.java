package com.onlinemall.mapper;

import com.onlinemall.interfaces.BaseMapper;
import com.onlinemall.mybatis_entity.Buyer;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerMapper extends BaseMapper<Buyer> {
    /**
     * 用户注册
     *
     * @param buyer
     * @return
     */
    int register(Buyer buyer);
}