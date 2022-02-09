package com.onlinemall.controller;

import com.onlinemall.common.Msg;
import com.onlinemall.common.Result;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.UserReq;
import com.onlinemall.service.UserService;
import com.onlinemall.tkmybatis.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author 11923
 */
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面
     */
    @RequestMapping("/login")
    public String loginIndex() {
        return "login/login";
    }

    /**
     * 跳转注册页面
     */
    @RequestMapping("/register")
    public String registerIndex() {
        return "login/register";
    }

    /**
     * 员工注册
     */
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
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
