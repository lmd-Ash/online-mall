package com.onlinemall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
    @RequestMapping("/test")
    public String test() {
        throw new NullPointerException();
//        return "test/index";
    }
}
