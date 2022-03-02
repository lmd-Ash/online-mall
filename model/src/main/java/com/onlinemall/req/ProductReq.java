package com.onlinemall.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
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
     * 商品售价(单位：元)
     */
    @NotBlank(message = "请输入售价", groups = {Insert.class, Update.class})
    private String sellingPrice;

    /**
     * 商品规格
     */
    @NotBlank(message = "规格不能为空", groups = {Insert.class, Update.class})
    private String specs;

    /**
     * 商品库存
     */
    @NotNull(message = "请输入库存", groups = {Insert.class, Update.class})
    @Min(value = 1, message = "库存不能小于1", groups = {Insert.class, Update.class})
    private Integer skuNum;

    /**
     * 图片集合
     */
    @NotNull(message = "图片不能为空", groups = {Insert.class})
    private List<String> imgUrlList;

    /**
     * 是否上架，1：是，0：否
     */
    private Boolean isShow;


}