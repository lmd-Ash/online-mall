package com.onlinemall.serviceImpl;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.mapper.BuyerMapper;
import com.onlinemall.mybatis_entity.Buyer;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.BuyerReq;
import com.onlinemall.resp.BuyerResp;
import com.onlinemall.resp.UserResp;
import com.onlinemall.server.RedisService;
import com.onlinemall.service.BuyerService;
import com.onlinemall.utils.JwtUtil;
import com.onlinemall.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Objects;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerMapper buyerMapper;
    @Autowired
    private RedisService redisService;
    /**
     * 用户session过期时间
     */
    @Value("${token.timeout}")
    private Integer tokenTimeOut;

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

    @Override
    public BuyerResp buyerLogin(BuyerReq buyerReq) {
        Buyer buyer = this.findByLoginName(buyerReq.getLoginName());
        String md5Password = MD5Util.stringMD5(buyerReq.getPassword());
        if (!Objects.equals(buyer.getPassword(), md5Password)) {
            return null;
        }
        // 生成token
        String token = JwtUtil.createToken(buyer.getId().toString());
        BuyerResp buyerResp = BeanMapper.map(buyer, BuyerResp.class);
        assert buyerResp != null;
        buyerResp.setToken(token);
        // 存入redis
        redisService.set("buyer:".concat(buyer.getId().toString()), buyer, Long.valueOf(tokenTimeOut));
        return buyerResp;
    }
}
