package com.onlinemall.mapper;

import com.onlinemall.interfaces.BaseMapper;
import com.onlinemall.mybatis_entity.Order;
import com.onlinemall.mybatis_entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 保存商品并返回主键
     *
     * @param order
     * @return 返回插入后的主键
     */
    Integer saveOrder(Order order);
}