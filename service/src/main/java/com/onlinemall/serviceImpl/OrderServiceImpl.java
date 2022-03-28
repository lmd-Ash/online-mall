package com.onlinemall.serviceImpl;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.common.Msg;
import com.onlinemall.enmu.OrderEnum;
import com.onlinemall.exception.CustomException;
import com.onlinemall.mapper.OrderMapper;
import com.onlinemall.mybatis_entity.Order;
import com.onlinemall.mybatis_entity.OrderDetail;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.req.OrderReq;
import com.onlinemall.resp.BuyerResp;
import com.onlinemall.resp.OrderResp;
import com.onlinemall.server.RedisService;
import com.onlinemall.service.OrderDetailService;
import com.onlinemall.service.OrderService;
import com.onlinemall.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailService orderDetailService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer createOrder(OrderReq orderReq, BuyerResp buyerResp) {
        Order order = BeanMapper.map(orderReq, Order.class);
        assert order != null;
        order.setBuyerId(buyerResp.getId());
        order.setOrderNo(redisService.getOrderNo());
        order.setOrderStatus(OrderEnum.TO_BE_DELIVERED.code);
        // 计算总价
        Product product = productService.findById(orderReq.getProductId());
        BigDecimal totalPrice = product.getSellingPrice().multiply(new BigDecimal(orderReq.getProductNum()));
        order.setTotalPrice(totalPrice);
        Integer orderId = orderMapper.saveOrder(order);
        if (Objects.isNull(orderId)) {
            throw new CustomException(Msg.ORDER_FAIL, Msg.TEXT_ORDER_SAVE_FAIL);
        }
        // 保存订单详情
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setOrderNo(order.getOrderNo());
        orderDetail.setProductId(product.getId());
        orderDetail.setProductNum(orderReq.getProductNum());
        orderDetail.setSellingPrice(product.getSellingPrice());
        OrderDetail saveOrderDetail = orderDetailService.save(orderDetail);
        if (Objects.isNull(saveOrderDetail)) {
            throw new CustomException(Msg.ORDER_FAIL, Msg.TEXT_ORDER_SAVE_FAIL);
        }
        return orderId;
    }

    @Override
    public List<OrderResp> findAllByBuyerId(OrderReq orderReq) {
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("buyerId", orderReq.getBuyerId());
        List<Order> orders = orderMapper.selectByExample(example);
        return BeanMapper.mapList(orders, OrderResp.class);
    }

    @Override
    public List<OrderResp> findAll(OrderReq orderReq) {
        Example example = new Example(Order.class);
        if (StringUtils.isNotBlank(orderReq.getOrderNo())) {
            example.createCriteria().andEqualTo("isAvailable", true)
                    .andEqualTo("orderNo", orderReq.getOrderNo());
        } else {
            example.createCriteria().andEqualTo("isAvailable", true);
        }
        List<Order> orders = orderMapper.selectByExample(example);
        return BeanMapper.mapList(orders, OrderResp.class);
    }
}
