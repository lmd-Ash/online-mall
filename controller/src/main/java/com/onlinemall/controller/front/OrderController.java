package com.onlinemall.controller.front;

import com.onlinemall.common.Msg;
import com.onlinemall.common.Result;
import com.onlinemall.req.OrderReq;
import com.onlinemall.resp.BuyerResp;
import com.onlinemall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController(value = "frontOrderController")
@RequestMapping("/front/order")
public class OrderController {
    /**
     * session用户Key
     */
    @Value("${session.buyer.key}")
    private String buyerSession;
    @Autowired
    private OrderService orderService;

    private BuyerResp getBuyer(HttpSession session) {
        return (BuyerResp) session.getAttribute(buyerSession);
    }

    @PostMapping("/createOrder")
    public Result createOrder(@RequestBody OrderReq orderReq, HttpSession session) {
        BuyerResp buyerResp = getBuyer(session);
        Integer order = orderService.createOrder(orderReq, buyerResp);
        if (order < 1) {
            return Result.build(Msg.ORDER_FAIL, Msg.TEXT_ORDER_SAVE_FAIL);
        }
        return Result.buildOk();
    }
}
