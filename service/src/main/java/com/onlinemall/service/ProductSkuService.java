package com.onlinemall.service;

import com.onlinemall.mybatis_entity.ProductSku;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.resp.ProductSkuResp;

import java.util.List;

public interface ProductSkuService {

    /**
     * 保存商品sku
     *
     * @param productReq
     * @return
     */
    int save(ProductReq productReq, User user);

    /**
     * 根据商品id查询商品sku集合
     *
     * @param productId
     * @return
     */
    List<ProductSkuResp> findAllByProductId(Integer productId);

    /**
     * 根据商品id查询商品sku集合
     *
     * @param productIds
     * @return
     */
    List<ProductSku> findAllByProductIds(List<Integer> productIds);
}
