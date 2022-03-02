package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Product extends BaseEntity {
    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品分类id
     */
    @Column(name = "product_type_id")
    private Integer productTypeId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 图片url集合
     */
    @Column(name = "img_urls")
    private String imgUrls;

    /**
     * 商品售价(单位：元)
     */
    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    /**
     * 商品规格
     */
    @Column(name = "specs")
    private String specs;

    /**
     * 商品库存
     */
    @Column(name = "sku_num")
    private Integer skuNum;

    /**
     * 是否上架，1：是，0：否
     */
    @Column(name = "is_show")
    private Boolean isShow;

    /**
     * 上架时间
     */
    @Column(name = "show_time")
    private Date showTime;

    /**
     * 上架操作人id
     */
    @Column(name = "show_user_id")
    private Integer showUserId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 修改人id
     */
    @Column(name = "update_user_id")
    private Integer updateUserId;

    /**
     * 是否可用，1：可用，0：不可用
     */
    @Column(name = "is_available")
    private Boolean isAvailable;

    /**
     * 获取商品id
     *
     * @return id - 商品id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品id
     *
     * @param id 商品id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品分类id
     *
     * @return product_type_id - 商品分类id
     */
    public Integer getProductTypeId() {
        return productTypeId;
    }

    /**
     * 设置商品分类id
     *
     * @param productTypeId 商品分类id
     */
    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取图片url集合
     *
     * @return img_urls - 图片url集合
     */
    public String getImgUrls() {
        return imgUrls;
    }

    /**
     * 设置图片url集合
     *
     * @param imgUrls 图片url集合
     */
    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    /**
     * 获取商品售价(单位：元)
     *
     * @return selling_price - 商品售价(单位：元)
     */
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    /**
     * 设置商品售价(单位：元)
     *
     * @param sellingPrice 商品售价(单位：元)
     */
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * 获取商品规格
     *
     * @return specs - 商品规格
     */
    public String getSpecs() {
        return specs;
    }

    /**
     * 设置商品规格
     *
     * @param specs 商品规格
     */
    public void setSpecs(String specs) {
        this.specs = specs;
    }

    /**
     * 获取商品库存
     *
     * @return sku_num - 商品库存
     */
    public Integer getSkuNum() {
        return skuNum;
    }

    /**
     * 设置商品库存
     *
     * @param skuNum 商品库存
     */
    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    /**
     * 获取是否上架，1：是，0：否
     *
     * @return is_show - 是否上架，1：是，0：否
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * 设置是否上架，1：是，0：否
     *
     * @param isShow 是否上架，1：是，0：否
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取上架时间
     *
     * @return show_time - 上架时间
     */
    public Date getShowTime() {
        return showTime;
    }

    /**
     * 设置上架时间
     *
     * @param showTime 上架时间
     */
    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    /**
     * 获取上架操作人id
     *
     * @return show_user_id - 上架操作人id
     */
    public Integer getShowUserId() {
        return showUserId;
    }

    /**
     * 设置上架操作人id
     *
     * @param showUserId 上架操作人id
     */
    public void setShowUserId(Integer showUserId) {
        this.showUserId = showUserId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人id
     *
     * @return create_user_id - 创建人id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人id
     *
     * @param createUserId 创建人id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取修改人id
     *
     * @return update_user_id - 修改人id
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置修改人id
     *
     * @param updateUserId 修改人id
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取是否可用，1：可用，0：不可用
     *
     * @return is_available - 是否可用，1：可用，0：不可用
     */
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * 设置是否可用，1：可用，0：不可用
     *
     * @param isAvailable 是否可用，1：可用，0：不可用
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}