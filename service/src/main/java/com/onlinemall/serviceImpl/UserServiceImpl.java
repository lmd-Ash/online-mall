package com.onlinemall.serviceImpl;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.mapper.UserMapper;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.UserReq;
import com.onlinemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 11923
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer userRegister(UserReq userReq) {
        User user = BeanMapper.map(userReq, User.class);
        return userMapper.insert(user);
    }

    @Override
    public User findByLoginName(String loginName) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("loginName", loginName);
        return userMapper.selectOneByExample(example);
    }
}
