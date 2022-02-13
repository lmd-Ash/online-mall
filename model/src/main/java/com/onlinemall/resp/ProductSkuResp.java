package com.onlinemall.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSkuResp implements Serializable {

    /**
     * 商品售价(单位：元)
     */
    private String sellingPrice;

    /**
     * 商品成本价(单位：元)
     */
    private String costPrice;

    /**
     * 商品规格
     */
    private String specs;

    /**
     * 商品单位
     */
    private String unit;

    /**
     * 商品库存
     */
    private Integer skuNum;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 修改人id
     */
    private Integer updateUserId;

    /**
     * 修改人名称
     */
    private String updateUserName;
}
