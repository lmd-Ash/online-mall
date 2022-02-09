package com.onlinemall.mapper;

import com.onlinemall.interfaces.BaseMapper;
import com.onlinemall.mybatis_entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 11923
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    int register(User user);
}