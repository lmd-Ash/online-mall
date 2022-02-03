package com.onlinemall.service;

import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.UserReq;

/**
 * @author 11923
 */
public interface UserService {
    /**
     * 员工注册
     *
     * @param userReq
     * @return
     */
    Integer userRegister(UserReq userReq);

    /**
     * 根据登录名查询用户
     *
     * @param loginName
     * @return
     */
    User findByLoginName(String loginName);
}
