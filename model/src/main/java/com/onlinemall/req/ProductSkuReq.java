package com.onlinemall.req;

import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductSkuReq extends BaseReq implements Serializable {

    /**
     * 商品售价(单位：元)
     */
    @NotBlank(message = "请输入售价", groups = {Insert.class, Update.class})
    private String sellingPrice;

    /**
     * 商品成本价(单位：元)
     */
    @NotBlank(message = "请输入成本价", groups = {Insert.class, Update.class})
    private String costPrice;

    /**
     * 商品规格
     */
    @NotBlank(message = "规格不能为空", groups = {Insert.class, Update.class})
    private String specs;

    /**
     * 商品单位
     */
    @NotBlank(message = "单位不能为空", groups = {Insert.class, Update.class})
    private String unit;

    /**
     * 商品库存
     */
    @NotNull(message = "请输入库存", groups = {Insert.class, Update.class})
    @Min(value = 1, message = "库存不能小于1", groups = {Insert.class, Update.class})
    private Integer skuNum;
}
