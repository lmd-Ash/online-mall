package com.onlinemall.serviceImpl;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.mapper.UserMapper;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.UserReq;
import com.onlinemall.resp.UserResp;
import com.onlinemall.server.RedisService;
import com.onlinemall.service.UserService;
import com.onlinemall.utils.JwtUtil;
import com.onlinemall.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Objects;

/**
 * @author 11923
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisService redisService;
    /**
     * 用户session过期时间
     */
    @Value("${token.timeout}")
    private Integer tokenTimeOut;

    @Override
    public Integer userRegister(UserReq userReq) {
        User user = BeanMapper.map(userReq, User.class);
        String md5Password = MD5Util.stringMD5(userReq.getPassword());
        assert user != null;
        user.setPassword(md5Password);
        return userMapper.register(user);
    }

    @Override
    public User findByLoginName(String loginName) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("loginName", loginName);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public UserResp userLogin(UserReq userReq) {
        User user = this.findByLoginName(userReq.getLoginName());
        String md5Password = MD5Util.stringMD5(userReq.getPassword());
        if (!Objects.equals(user.getPassword(), md5Password)) {
            return null;
        }
        // 生成token
        String token = JwtUtil.createToken(user.getId().toString());
        UserResp userResp = BeanMapper.map(user, UserResp.class);
        assert userResp != null;
        userResp.setToken(token);
        // 存入redis
        redisService.set("user:".concat(user.getId().toString()), user, Long.valueOf(tokenTimeOut));
        return userResp;
    }

    @Override
    public User findById(Integer id) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("id", id);
        return userMapper.selectOneByExample(example);
    }
}
