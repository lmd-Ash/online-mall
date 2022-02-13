package com.onlinemall.mapper;

import com.onlinemall.interfaces.BaseMapper;
import com.onlinemall.mybatis_entity.ProductType;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeMapper extends BaseMapper<ProductType> {
    /**
     * 保存商品分类
     *
     * @param productType
     * @return
     */
    Integer saveProductType(ProductType productType);

    /**
     * 修改商品分类
     *
     * @param productType
     * @return
     */
    Integer updateProductType(ProductType productType);
}