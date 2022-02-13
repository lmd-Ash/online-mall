package com.onlinemall.mapper;

import com.onlinemall.interfaces.BaseMapper;
import com.onlinemall.mybatis_entity.ProductSku;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSkuMapper extends BaseMapper<ProductSku> {
    /**
     * 保存商品sku
     *
     * @param productSku
     * @return
     */
    Integer batchSave(List<ProductSku> productSku);
}