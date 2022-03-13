package com.onlinemall.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.onlinemall.req.BaseReq;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductResp extends BaseReq implements Serializable {
    /**
     * 商品id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    /**
     * 商品分类id
     */
    private Integer productTypeId;

    private String productTypeName;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品售价(单位：元)
     */
    private String sellingPrice;

    /**
     * 商品规格
     */
    private String specs;

    /**
     * 商品库存
     */
    private Integer skuNum;

    /**
     * 是否上架，1：是，0：否
     */
    private Boolean isShow;


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

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date showTime;

    /**
     * 修改人id
     */
    private Integer showUserId;

    /**
     * 修改人名称
     */
    private String showUserName;

    /**
     * 图片url集合
     */
    private List<String> imgUrlList;

    /**
     * 图片url集合
     */
    private String imgUrls;

}