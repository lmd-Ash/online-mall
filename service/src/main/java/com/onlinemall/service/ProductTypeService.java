package com.onlinemall.service;

import com.onlinemall.mybatis_entity.ProductType;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductTypeReq;
import com.onlinemall.resp.ProductTypeResp;

import java.util.List;

public interface ProductTypeService {
    /**
     * 保存商品分类
     *
     * @param productTypeReq
     * @return
     */
    int saveProductType(ProductTypeReq productTypeReq, User user);

    /**
     * 查询商品分类
     *
     * @param productTypeReq
     * @return
     */
    List<ProductTypeResp> findAll(ProductTypeReq productTypeReq);

    /**
     * 修改商品分类
     *
     * @param productTypeReq
     * @param user
     * @return
     */
    int updateProductType(ProductTypeReq productTypeReq, User user);

    /**
     * 根据id查询商品分类
     *
     * @param id
     * @return
     */
    ProductType findById(Integer id);
}
