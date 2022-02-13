package com.onlinemall.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductReq extends BaseReq implements Serializable {
    /**
     * 商品id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    /**
     * 商品分类id
     */
    @NotNull(message = "请选择分类", groups = {Insert.class, Update.class})
    private Integer productTypeId;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名不能为空", groups = {Insert.class, Update.class})
    private String productName;

    /**
     * 商品sku集合
     */
    private List<ProductSkuReq> productSkuReqs;

    /**
     * 是否上架，1：是，0：否
     */
    private Boolean isShow;


}