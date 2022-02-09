package com.onlinemall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lmd
 * @version 1.0.0
 * @date 2020/10/11
 */
@SpringBootApplication
@MapperScan("com.onlinemall.mapper")
public class ApplicationRun9527 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun9527.class, args);
    }
}
