package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_sku")
public class ProductSku extends BaseEntity {
    /**
     * 商品skuid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品id
     */
    @Column(name = "product_Id")
    private Integer productId;

    /**
     * 商品售价(单位：元)
     */
    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    /**
     * 商品成本价(单位：元)
     */
    @Column(name = "cost_price")
    private BigDecimal costPrice;

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
    @Column(name = "sku_num")
    private Integer skuNum;

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
     * 获取商品skuid
     *
     * @return id - 商品skuid
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品skuid
     *
     * @param id 商品skuid
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品id
     *
     * @return product_Id - 商品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品id
     *
     * @param productId 商品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
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
     * 获取商品成本价(单位：元)
     *
     * @return cost_price - 商品成本价(单位：元)
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * 设置商品成本价(单位：元)
     *
     * @param costPrice 商品成本价(单位：元)
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
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
     * 获取商品单位
     *
     * @return unit - 商品单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置商品单位
     *
     * @param unit 商品单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
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