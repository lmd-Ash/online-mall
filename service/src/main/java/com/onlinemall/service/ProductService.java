package com.onlinemall.service;

import com.onlinemall.req.ProductReq;

public interface ProductService {
    /**
     * 保存商品
     *
     * @param productReq
     * @return
     */
    int saveProduct(ProductReq productReq);
}
