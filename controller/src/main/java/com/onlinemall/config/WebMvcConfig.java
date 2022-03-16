package com.onlinemall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lmd
 * @version 1.0.0
 * @date 2020/10/11
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 注入 token 拦截器
     */
    @Autowired
    private TokenInterceptor interceptor;
    @Autowired
    private FrontLoginInterceptor frontLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                // 需要拦截的uri
                .addPathPatterns("/back/**")
                // 需要跳过的uri
                .excludePathPatterns("/back/user/register", "/back/user/login", "/back/product/upload", "/back/product/list",
                        "/back/productType/findAll")
                // 拦截器的执行顺序 设置高一点方便后期扩展
                .order(1);
        registry.addInterceptor(frontLoginInterceptor)
                // 需要拦截的uri
                .addPathPatterns("/front/**")
                // 需要跳过的uri
                .excludePathPatterns("/front/buyer/register", "/front/buyer/login", "/front/product/list")
                // 拦截器的执行顺序 设置高一点方便后期扩展
                .order(1);
    }
}
