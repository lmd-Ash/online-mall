package com.onlinemall.controller.back;

import com.onlinemall.common.Msg;
import com.onlinemall.common.Result;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.UserReq;
import com.onlinemall.resp.UserResp;
import com.onlinemall.service.UserService;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    /**
     * 员工登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody @Validated(Update.class) UserReq userReq) {
        User user = userService.findByLoginName(userReq.getLoginName());
        if (Objects.isNull(user)) {
            return Result.buildFail(Msg.TEXT_USER_DATA_FAIL);
        }
        UserResp userResp = userService.userLogin(userReq);
        if (Objects.isNull(userResp)) {
            return Result.buildFail(Msg.TEXT_USER_DATA_FAIL);
        }
        return Result.build(Msg.OK, Msg.TEXT_LOGIN_OK, userResp);
    }

    @GetMapping("/list")
    public Result list(UserReq userReq) {
        List<UserResp> userResps = userService.findAll(userReq);
        return Result.buildQueryOk(userResps);
    }
}
