package com.onlinemall.controller.front;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.common.MyPageInfo;
import com.onlinemall.common.Result;
import com.onlinemall.mybatis_entity.Buyer;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.req.ProductReq;
import com.onlinemall.resp.ProductResp;
import com.onlinemall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author 11923
 */
@RestController(value = "frontProductController")
@RequestMapping("/front/product")
public class ProductController {
    /**
     * session用户Key
     */
    @Value("${session.buyer.key}")
    private String buyerSession;
    @Autowired
    private ProductService productService;

    private Buyer getBuyer(HttpSession session) {
        return (Buyer) session.getAttribute(buyerSession);
    }

    /**
     * 分页查询商品
     */
    @GetMapping("/page")
    public Result<MyPageInfo<ProductResp>> page(ProductReq productReq) {
        MyPageInfo<ProductResp> pageInfo = productService.pageAll(productReq);
        return Result.buildQueryOk(pageInfo);
    }

    /**
     * 查询商品集合
     */
    @GetMapping("/list")
    public Result<List<ProductResp>> list(ProductReq productReq) {
        List<ProductResp> productResps = productService.findAll(productReq);
        return Result.buildQueryOk(productResps);
    }

    /**
     * 根据id查询商品
     */
    @GetMapping("/find")
    public Result<ProductResp> find(ProductReq productReq) {
        Product product = productService.findById(productReq.getId());
        if (Objects.isNull(product)) {
            return Result.buildOk();
        }
        ProductResp productResp = BeanMapper.map(product, ProductResp.class);
        return Result.buildQueryOk(productResp);
    }

}
