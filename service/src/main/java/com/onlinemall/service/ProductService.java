package com.onlinemall.service;

import com.onlinemall.common.MallPage;
import com.onlinemall.common.MyPageInfo;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.resp.ProductResp;

import java.util.List;
import java.util.Map;

public interface ProductService {
    /**
     * 保存商品
     *
     * @param productReq
     * @return
     */
    int saveProduct(ProductReq productReq, User user);

    /**
     * 根据商品id查询商品
     *
     * @param id
     * @return
     */
    Product findById(Integer id);

    /**
     * 查询商品集合
     *
     * @param productReq
     * @return
     */
    MyPageInfo<Map<String, String>> findAll(ProductReq productReq);

    /**
     * 查询商品集合
     *
     * @param productReq
     * @return
     */
    MyPageInfo<ProductResp> pageAll(ProductReq productReq);
}
