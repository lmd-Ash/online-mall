package com.onlinemall.controller;

import com.onlinemall.common.Msg;
import com.onlinemall.common.Result;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.UserReq;
import com.onlinemall.service.UserService;
import com.onlinemall.tkmybatis.Insert;
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
@RequestMapping("/back/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 员工注册
     */
    @PostMapping(value = "/register")
    public Result userRegister(@RequestBody @Validated(Insert.class) UserReq userReq) {
        User user = userService.findByLoginName(userReq.getLoginName());
        if (Objects.nonNull(user)) {
            return Result.build(Msg.FAIL, Msg.TEXT_LOGIN_NAME_EXIST);
        }
        Integer integer = userService.userRegister(userReq);
        if (integer > 0) {
            return Result.build(Msg.OK, Msg.TEXT_REGISTER_OK);
        }
        return Result.build(Msg.FAIL, Msg.TEXT_REGISTER_FAIL);
    }
}
