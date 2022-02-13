package com.onlinemall.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.onlinemall.common.BeanMapper;
import com.onlinemall.common.Msg;
import com.onlinemall.common.MyPageInfo;
import com.onlinemall.exception.CustomException;
import com.onlinemall.mapper.ProductMapper;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.mybatis_entity.ProductSku;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.resp.ProductResp;
import com.onlinemall.resp.ProductSkuResp;
import com.onlinemall.service.ProductService;
import com.onlinemall.service.ProductSkuService;
import com.onlinemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @Autowired
    private ProductSkuService productSkuService;

    private User init(HttpSession session) {
        User user = (User) session.getAttribute(userSession);
        user = userService.findById(user.getId());
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveProduct(ProductReq productReq, User user) {
        // 保存商品基本信息
        Product product = BeanMapper.map(productReq, Product.class);
        assert product != null;
        product.setCreateUserId(user.getId());
        Integer key = productMapper.saveProduct(product);
        if (Objects.isNull(key)) {
            throw new CustomException(Msg.TEXT_SAVE_FAIL);
        }
        // 保存商品sku信息
        productReq.setId(key);
        int save = productSkuService.save(productReq, user);
        if (save < 1) {
            throw new CustomException(Msg.TEXT_SAVE_FAIL);
        }
        return save;
    }

    @Override
    public Product findById(Integer id) {
        Example example = new Example(Product.class);
        example.createCriteria().andEqualTo("isAvailable", true)
                .andEqualTo("id", id);
        return productMapper.selectOneByExample(example);
    }

    @Override
    public MyPageInfo<Map<String, String>> findAll(ProductReq productReq) {
        Map<String, String> searchMap = this.getSearchMap(productReq);
        List<Map<String, String>> mapList = productMapper.findAllByMap(searchMap);
        return new MyPageInfo<>(mapList);
    }

    @Override
    public MyPageInfo<ProductResp> pageAll(ProductReq productReq) {
        Map<String, String> searchMap = this.getSearchMap(productReq);
        List<ProductResp> productResps = productMapper.findAll(searchMap);
        // 获取商品id集合
        List<Integer> productIds = productResps.stream().map(ProductResp::getId).collect(Collectors.toList());
        // 查询商品sku集合
        List<ProductSku> productSkus = productSkuService.findAllByProductIds(productIds);
        // 转换成productId为key，ProductSku集合为value map
        Map<Integer, List<ProductSku>> productSkusMap = productSkus.stream().collect(Collectors.groupingBy(ProductSku::getProductId));
        for (ProductResp productResp : productResps) {
            List<ProductSku> productSkuList = productSkusMap.get(productResp.getProductTypeId());
            productResp.setProductSkuResps(BeanMapper.mapList(productSkuList, ProductSkuResp.class));
        }
        return new MyPageInfo<>(productResps);
    }

    private Map<String, String> getSearchMap(ProductReq productReq) {
        Map<String, String> searchMap = new HashMap<>(16);
        PageHelper.startPage(productReq.getPage(), productReq.getPageSize());
        searchMap.put("productName", productReq.getProductName());
        searchMap.put("productTypeId", Objects.nonNull(productReq.getProductTypeId()) ? productReq.getProductTypeId().toString() : null);
        return searchMap;
    }
}
