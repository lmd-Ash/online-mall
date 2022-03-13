package com.onlinemall.service;

import com.onlinemall.common.MyPageInfo;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.resp.ProductResp;

import java.util.List;

public interface ProductService {
    /**
     * 保存商品
     *
     * @param productReq
     * @return
     */
    Integer saveProduct(ProductReq productReq, User user);

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
    List<ProductResp> findAll(ProductReq productReq);

    /**
     * 查询商品集合
     *
     * @param productReq
     * @return
     */
    MyPageInfo<ProductResp> pageAll(ProductReq productReq);

    /**
     * 更新商品
     *
     * @param productReq
     * @param user
     * @return
     */
    Integer update(ProductReq productReq, User user);
}
