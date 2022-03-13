package com.onlinemall.controller;

import com.onlinemall.common.BeanMapper;
import com.onlinemall.common.Msg;
import com.onlinemall.common.MyPageInfo;
import com.onlinemall.common.Result;
import com.onlinemall.mybatis_entity.Product;
import com.onlinemall.mybatis_entity.User;
import com.onlinemall.req.ProductReq;
import com.onlinemall.resp.ProductResp;
import com.onlinemall.server.FastdfsService;
import com.onlinemall.service.ProductService;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import com.onlinemall.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 11923
 */
@RestController
@RequestMapping("/back/product")
public class ProductController {
    /**
     * session用户Key
     */
    @Value("${session.user.key}")
    private String sessionUser;
    @Autowired
    private ProductService productService;
    @Autowired
    private FastdfsService fastdfsService;

    private User getUser(HttpSession session) {
        return (User) session.getAttribute(sessionUser);
    }

    /**
     * 上传图片
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("imgList") MultipartFile[] multipartFiles) {
        if (multipartFiles.length < 1) {
            return Result.build(Msg.IMAGE_FAIL, Msg.TEXT_IMAGE_EMPTY);
        }
        List<String> imgUrls = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String suffixName = FileUtils.getSuffixName(file.getOriginalFilename());
            if (!FileUtils.isImg(suffixName)) {
                return Result.build(Msg.IMAGE_FAIL, Msg.TEXT_IMAGE_FAIL);
            }
            try {
                String fileUrl = fastdfsService.uploadFile(file.getInputStream(), suffixName);
                imgUrls.add(fileUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.buildOk(imgUrls);
    }

    /**
     * 保存商品
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated(Insert.class) ProductReq productReq, HttpSession session) {
        User user = getUser(session);
        Integer integer = productService.saveProduct(productReq, user);
        if (Objects.isNull(integer)) {
            return Result.buildSaveFail();
        }
        return Result.buildSaveOk();
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

    /**
     * 修改商品
     */
    @PostMapping("/edit")
    public Result<String> edit(@RequestBody @Validated(Update.class) ProductReq productReq, HttpSession session) {
        Product product = productService.findById(productReq.getId());
        if (Objects.isNull(product)) {
            return Result.buildOk();
        }
        User user = getUser(session);
        Integer update = productService.update(productReq, user);
        if (update < 1) {
            return Result.buildSaveFail();
        }
        return Result.buildSaveOk();
    }

}
