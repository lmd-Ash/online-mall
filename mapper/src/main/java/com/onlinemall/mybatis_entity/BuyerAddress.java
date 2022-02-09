package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "buyer_address")
public class BuyerAddress extends BaseEntity {
    /**
     * 商户地址id
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
     * 详细收货地址
     */
    private String address;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否默认 0：否，1：是
     */
    @Column(name = "is_default")
    private Boolean isDefault;

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
     * 获取商户地址id
     *
     * @return id - 商户地址id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商户地址id
     *
     * @param id 商户地址id
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
     * 获取详细收货地址
     *
     * @return address - 详细收货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细收货地址
     *
     * @param address 详细收货地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取收货人
     *
     * @return consignee - 收货人
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 设置收货人
     *
     * @param consignee 收货人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取是否默认 0：否，1：是
     *
     * @return is_default - 是否默认 0：否，1：是
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否默认 0：否，1：是
     *
     * @param isDefault 是否默认 0：否，1：是
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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