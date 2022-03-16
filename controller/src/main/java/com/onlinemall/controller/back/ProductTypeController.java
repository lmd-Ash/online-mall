package com.onlinemall.controller.back;

import com.onlinemall.common.Result;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.mybatis_entity.ProductType;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.req.ProductTypeReq;
import com.onlinemall.resp.ProductTypeResp;
import com.onlinemall.service.ProductTypeService;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author 11923
 */
@RestController
@RequestMapping("/back/productType")
public class ProductTypeController {
    /**
     * session用户Key
     */
    @Value("${session.user.key}")
    private String sessionUser;
    @Autowired
    private ProductTypeService productTypeService;

    private User getUser(HttpSession session) {
        return (User) session.getAttribute(sessionUser);
    }

    /**
     * 查询所有的商品分类
     */
    @GetMapping("/findAll")
    public Result<List<ProductTypeResp>> findAll(ProductTypeReq productTypeReq) {
        List<ProductTypeResp> productTypeResps = productTypeService.findAll(productTypeReq);
        return Result.buildQueryOk(productTypeResps);
    }

    /**
     * 保存商品分类
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated(Insert.class) ProductTypeReq productTypeReq, HttpSession session) {
        User user = getUser(session);
        int integer = productTypeService.saveProductType(productTypeReq, user);
        if (integer < 1) {
            return Result.buildSaveFail();
        }
        return Result.buildSaveOk();
    }

    /**
     * 修改商品分类
     */
    @PostMapping("/edit")
    public Result<String> edit(@RequestBody @Validated(Update.class) ProductTypeReq productTypeReq, HttpSession session) {
        ProductType productType = productTypeService.findById(productTypeReq.getId());
        if (Objects.isNull(productType)) {
            return Result.buildSaveFail();
        }
        User user = getUser(session);
        int update = productTypeService.updateProductType(productTypeReq, user);
        if (update < 1) {
            return Result.buildSaveFail();
        }
        return Result.buildSaveOk();
    }
}
