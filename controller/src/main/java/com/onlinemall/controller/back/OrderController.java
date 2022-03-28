package com.onlinemall.controller.back;

import com.onlinemall.common.Result;
import com.onlinemall.mybatis_entity.Order;
import com.onlinemall.req.OrderReq;
import com.onlinemall.resp.OrderResp;
import com.onlinemall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/back/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/findAll")
    public Result findAll(OrderReq orderReq, HttpSession session) {
        List<OrderResp> orders = orderService.findAll(orderReq);
        return Result.buildQueryOk(orders);
    }
}
