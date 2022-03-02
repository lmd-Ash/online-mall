package com.onlinemall.controller;

import com.onlinemall.common.Result;
import com.onlinemall.req.ProductTypeReq;
import com.onlinemall.resp.ProductTypeResp;
import com.onlinemall.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11923
 */
@RestController
@RequestMapping("/back/productType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 查询所有的商品分类
     */
    @GetMapping("/findAll")
    public Result<List<ProductTypeResp>> findAll(ProductTypeReq productTypeReq) {
        List<ProductTypeResp> productTypeResps = productTypeService.findAll(productTypeReq);
        return Result.buildQueryOk(productTypeResps);
    }
}
