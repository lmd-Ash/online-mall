package com.onlinemall.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.onlinemall.common.BeanMapper;
import com.onlinemall.common.Msg;
import com.onlinemall.common.MyPageInfo;
import com.onlinemall.exception.CustomException;
import com.onlinemall.mapper.ProductMapper;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.resp.ProductResp;
import com.onlinemall.service.ProductService;
import com.onlinemall.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    /**
     * session用户Key
     */
    @Value("${session.user.key}")
    private String userSession;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserService userService;

    private User init(HttpSession session) {
        User user = (User) session.getAttribute(userSession);
        user = userService.findById(user.getId());
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveProduct(ProductReq productReq, User user) {
        StringBuilder builder = new StringBuilder();
        // 保存商品基本信息
        Product product = BeanMapper.map(productReq, Product.class);
        assert product != null;
        product.setCreateUserId(user.getId());
        for (String imgUrl : productReq.getImgUrlList()) {
            builder.append(imgUrl).append(";");
        }
        product.setImgUrls(builder.toString());
        Integer key = productMapper.saveProduct(product);
        if (Objects.isNull(key)) {
            throw new CustomException(Msg.TEXT_SAVE_FAIL);
        }
        return key;
    }

    @Override
    public Product findById(Integer id) {
        Example example = new Example(Product.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("id", id);
        return productMapper.selectOneByExample(example);
    }

    @Override
    public List<ProductResp> findAll(ProductReq productReq) {
        Map<String, String> searchMap = this.getSearchMap(productReq);
        List<ProductResp> productResps = productMapper.findAll(searchMap);
        this.imgHandle(productResps);
        return productResps;
    }

    @Override
    public MyPageInfo<ProductResp> pageAll(ProductReq productReq) {
        Map<String, String> searchMap = this.getSearchMap(productReq);
        List<ProductResp> productResps = productMapper.findAll(searchMap);
        this.imgHandle(productResps);
        // 获取商品id集合
//        List<Integer> productIds = productResps.stream().map(ProductResp::getId).collect(Collectors.toList());
//        // 查询商品sku集合
//        List<ProductSku> productSkus = productSkuService.findAllByProductIds(productIds);
//        // 转换成productId为key，ProductSku集合为value map
//        Map<Integer, List<ProductSku>> productSkusMap = productSkus.stream().collect(Collectors.groupingBy(ProductSku::getProductId));
//        for (ProductResp productResp : productResps) {
//            List<ProductSku> productSkuList = productSkusMap.get(productResp.getProductTypeId());
//            productResp.setProductSkuResps(BeanMapper.mapList(productSkuList, ProductSkuResp.class));
//        }
        return new MyPageInfo<>(productResps);
    }

    @Override
    public Integer update(ProductReq productReq, User user) {
        Product product = BeanMapper.map(productReq, Product.class);
        assert product != null;
        product.setUpdateUserId(user.getId());
        return productMapper.update(product);
    }

    private Map<String, String> getSearchMap(ProductReq productReq) {
        Map<String, String> searchMap = new HashMap<>(16);
        PageHelper.startPage(productReq.getPage(), productReq.getPageSize());
        searchMap.put("productName", productReq.getProductName());
        searchMap.put("productTypeId", Objects.nonNull(productReq.getProductTypeId()) ? productReq.getProductTypeId().toString() : null);
        return searchMap;
    }

    private void imgHandle(List<ProductResp> productResps) {
        for (ProductResp productResp : productResps) {
            if (StringUtils.isNotBlank(productResp.getImgUrls())) {
                String[] imgUrls = productResp.getImgUrls().split(";");
                productResp.setImgUrlList(Arrays.asList(imgUrls));
            }
        }
    }
}
