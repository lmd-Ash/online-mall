package com.onlinemall.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.onlinemall.tkmybatis.BaseEntity;
import com.onlinemall.tkmybatis.Insert;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductReq extends BaseReq implements Serializable {
    /**
     * 商品id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名不能为空", groups = Insert.class)
    private String productName;

    /**
     * 商品售价(单位：元)
     */
    @NotBlank(message = "请输入售价", groups = Insert.class)
    private String sellingPrice;

    /**
     * 商品成本价(单位：元)
     */
    @NotBlank(message = "请输入成本价", groups = Insert.class)
    private String costPrice;

    /**
     * 商品规格
     */
    @NotBlank(message = "规格不能为空", groups = Insert.class)
    private String specs;

    /**
     * 商品单位
     */
    @NotBlank(message = "单位不能为空", groups = Insert.class)
    private String unit;

    /**
     * 商品库存
     */
    @NotNull(message = "请输入库存", groups = Insert.class)
    @Min(value = 1, message = "库存不能小于1", groups = Insert.class)
    private Integer skuNum;

    /**
     * 是否上架，1：是，0：否
     */
    private Boolean isShow;


}