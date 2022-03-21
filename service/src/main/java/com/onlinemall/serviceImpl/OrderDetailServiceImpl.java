package com.onlinemall.serviceImpl;

import com.onlinemall.mapper.OrderDetailMapper;
import com.onlinemall.mybatis_entity.OrderDetail;
import com.onlinemall.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailMapper.save(orderDetail);
    }
}
