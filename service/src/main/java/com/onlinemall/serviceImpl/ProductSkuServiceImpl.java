package com.onlinemall.serviceImpl;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.mapper.ProductSkuMapper;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.mybatis_entity.ProductSku;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.req.ProductSkuReq;
import com.onlinemall.resp.ProductSkuResp;
import com.onlinemall.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductSkuServiceImpl implements ProductSkuService {
    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public int save(ProductReq productReq, User user) {
        List<ProductSkuReq> productSkuReqs = productReq.getProductSkuReqs();
        List<ProductSku> productSkus = BeanMapper.mapList(productSkuReqs, ProductSku.class);
        for (ProductSku productSku : productSkus) {
            productSku.setProductId(productReq.getId());
            productSku.setCreateUserId(user.getId());
        }
        return productSkuMapper.batchSave(productSkus);
    }

    @Override
    public List<ProductSkuResp> findAllByProductId(Integer productId) {
        Example example = new Example(ProductSku.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("productId", productId);
        List<ProductSku> productSkus = productSkuMapper.selectByExample(example);
        return BeanMapper.mapList(productSkus, ProductSkuResp.class);
    }

    @Override
    public List<ProductSku> findAllByProductIds(List<Integer> productIds) {
        Example example = new Example(ProductSku.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andIn("productId", productIds);
        return productSkuMapper.selectByExample(example);
    }
}
