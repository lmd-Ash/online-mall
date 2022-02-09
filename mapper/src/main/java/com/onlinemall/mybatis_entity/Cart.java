package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.util.Date;
import javax.persistence.*;

public class Cart extends BaseEntity {
    /**
     * 购物车id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商户id
     */
    @Column(name = "buyer_id")
    private Integer buyerId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品数量
     */
    @Column(name = "product_num")
    private Integer productNum;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否可用，1：可用，0：不可用
     */
    @Column(name = "is_available")
    private Boolean isAvailable;

    /**
     * 获取购物车id
     *
     * @return id - 购物车id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置购物车id
     *
     * @param id 购物车id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商户id
     *
     * @return buyer_id - 商户id
     */
    public Integer getBuyerId() {
        return buyerId;
    }

    /**
     * 设置商户id
     *
     * @param buyerId 商户id
     */
    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * 获取商品id
     *
     * @return product_id - 商品id
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
     * 获取商品数量
     *
     * @return product_num - 商品数量
     */
    public Integer getProductNum() {
        return productNum;
    }

    /**
     * 设置商品数量
     *
     * @param productNum 商品数量
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
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