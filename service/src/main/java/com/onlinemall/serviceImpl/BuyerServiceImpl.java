package com.onlinemall.serviceImpl;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.mapper.BuyerMapper;
import com.onlinemall.mybatis_entity.Buyer;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.BuyerReq;
import com.onlinemall.service.BuyerService;
import com.onlinemall.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    public Integer buyerRegister(BuyerReq buyerReq) {
        Buyer buyer = BeanMapper.map(buyerReq, Buyer.class);
        String md5Password = MD5Util.stringMD5(buyerReq.getPassword());
        assert buyer != null;
        buyer.setPassword(md5Password);
        return buyerMapper.register(buyer);
    }

    @Override
    public Buyer findByLoginName(String loginName) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("loginName", loginName);
        return buyerMapper.selectOneByExample(example);
    }
}
