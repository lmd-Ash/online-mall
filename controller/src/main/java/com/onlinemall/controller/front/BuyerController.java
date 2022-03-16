package com.onlinemall.controller.front;

import com.onlinemall.common.Msg;
import com.onlinemall.common.Result;
import com.onlinemall.mybatis_entity.Buyer;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.BuyerReq;
import com.onlinemall.req.UserReq;
import com.onlinemall.resp.BuyerResp;
import com.onlinemall.resp.UserResp;
import com.onlinemall.service.BuyerService;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author 11923
 */
@RestController
@RequestMapping("/front/buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    /**
     * 员工注册
     */
    @PostMapping(value = "/register")
    public Result buyerRegister(@RequestBody @Validated(Insert.class) BuyerReq buyerReq) {
        Buyer buyer = buyerService.findByPhone(buyerReq.getPhone());
        if (Objects.nonNull(buyer)) {
            return Result.build(Msg.FAIL, Msg.TEXT_PHONE_EXIST);
        }
        Integer integer = buyerService.buyerRegister(buyerReq);
        if (integer > 0) {
            return Result.build(Msg.OK, Msg.TEXT_REGISTER_OK);
        }
        return Result.build(Msg.FAIL, Msg.TEXT_REGISTER_FAIL);
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody @Validated(Update.class) BuyerReq buyerReq) {
        Buyer buyer = buyerService.findByPhone(buyerReq.getPhone());
        if (Objects.isNull(buyer)) {
            return Result.buildFail(Msg.TEXT_USER_DATA_FAIL);
        }
        BuyerResp buyerResp = buyerService.buyerLogin(buyerReq);
        if (Objects.isNull(buyerResp)) {
            return Result.buildFail(Msg.TEXT_USER_DATA_FAIL);
        }
        return Result.build(Msg.OK, Msg.TEXT_LOGIN_OK, buyerResp);
    }
}
