package com.onlinemall.mapper;

import com.onlinemall.interfaces.BaseMapper;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.resp.ProductResp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 保存商品并返回主键
     *
     * @param product
     * @return 返回插入后的主键
     */
    Integer saveProduct(Product product);

    /**
     * 条件查询所有的商品
     *
     * @param searchMap
     * @return
     */
    List<Map<String, String>> findAllByMap(Map<String, String> searchMap);

    /**
     * 条件查询所有的商品数量
     *
     * @param searchMap
     * @return
     */
    Integer countByMap(Map<String, String> searchMap);

    List<ProductResp> findAll(Map<String, String> searchMap);
}