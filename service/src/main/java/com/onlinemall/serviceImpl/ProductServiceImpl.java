package com.onlinemall.serviceImpl;

import com.onlinemall.mapper.ProductMapper;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.service.ProductService;
import com.onlinemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ProductServiceImpl implements ProductService {
    /**
     * session用户Key
     */
    @Value("${session.user.key}")
    private String userSession;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserService userService;

    private User init(HttpSession session) {
        User user = (User) session.getAttribute(userSession);
        user = userService.findById(user.getId());
        return user;
    }

    @Override
    public int saveProduct(ProductReq productReq) {
        return 0;
    }
}
