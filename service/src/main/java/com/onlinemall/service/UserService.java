package com.onlinemall.service;

import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.UserReq;
import com.onlinemall.resp.UserResp;

import java.util.List;

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
     * 根据登录名查询员工
     *
     * @param loginName
     * @return
     */
    User findByLoginName(String loginName);

    /**
     * 员工登录
     *
     * @param userReq
     * @return
     */
    UserResp userLogin(UserReq userReq);

    /**
     * 根据主键查询员工
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 查询用户
     *
     * @param userReq
     * @return
     */
    List<UserResp> findAll(UserReq userReq);
}
