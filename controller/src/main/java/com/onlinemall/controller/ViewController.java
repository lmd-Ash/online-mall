package com.onlinemall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ViewController {
    /**
     * 跳转后管登录页面
     */
    @RequestMapping("/back/login")
    public String loginIndex() {
        return "login/login";
    }

    /**
     * 跳转后管登录页面
     */
    @RequestMapping("/login")
    public String login() {
        return "login/buyerLogin";
    }


    /**
     * 跳转注册页面
     */
    @RequestMapping("/register")
    public String registerIndex() {
        return "login/register";
    }

    /**
     * 跳转转后管商品
     */
    @RequestMapping("/product")
    public String backProduct() {
        return "product/frontProduct";
    }
}
