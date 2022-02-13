package com.onlinemall.serviceImpl;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.mapper.ProductTypeMapper;
import com.onlinemall.mybatis_entity.ProductType;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductTypeReq;
import com.onlinemall.resp.ProductTypeResp;
import com.onlinemall.service.ProductTypeService;
import com.onlinemall.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public int saveProductType(ProductTypeReq productTypeReq, User user) {
        ProductType productType = BeanMapper.map(productTypeReq, ProductType.class);
        assert productType != null;
        productType.setCreateUserId(user.getId());
        return productTypeMapper.saveProductType(productType);
    }

    @Override
    public List<ProductTypeResp> findAll(ProductTypeReq productTypeReq) {
        List<ProductType> productTypes;
        Example example = new Example(ProductType.class);
        if (StringUtil.isEmpty(productTypeReq.getProductTypeName())) {
            example.createCriteria().andEqualTo("isAvailable", true);
        } else {
            example.createCriteria().andEqualTo("isAvailable", true)
                    .andLike("productTypeName", "%".concat(productTypeReq.getProductTypeName()).concat("%"));
        }
        productTypes = productTypeMapper.selectByExample(example);
        return BeanMapper.mapList(productTypes, ProductTypeResp.class);
    }

    @Override
    public int updateProductType(ProductTypeReq productTypeReq, User user) {
        ProductType productType = BeanMapper.map(productTypeReq, ProductType.class);
        assert productType != null;
        productType.setUpdateUserId(user.getId());
        return productTypeMapper.updateProductType(productType);
    }

    @Override
    public ProductType findById(Integer id) {
        Example example = new Example(ProductType.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("id", id);
        return productTypeMapper.selectOneByExample(example);
    }
}
