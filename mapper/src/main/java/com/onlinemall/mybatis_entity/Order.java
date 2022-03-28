package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "torder")
public class Order extends BaseEntity {
    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 商户id
     */
    @Column(name = "buyer_id")
    private Integer buyerId;

    /**
     * 订单总价(单位：元)
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 收货地址
     */
    @Column(name = "detail_address")
    private String detailAddress;

    /**
     * 收货人姓名
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收货人手机号
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 订单状态：100:未支付；200:已取消；300:待发货；400:待收货；500:已签收
     */
    @Column(name = "order_status")
    private Integer orderStatus;

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
     * 附言
     */
    private String note;

    /**
     * 发货时间
     */
    @Column(name = "deliver_time")
    private Date deliverTime;

    /**
     * 是否评价：1：是，0：否
     */
    @Column(name = "is_evaluate")
    private Boolean isEvaluate;

    /**
     * 是否可用，1：可用，0：不可用
     */
    @Column(name = "is_available")
    private Boolean isAvailable;

    /**
     * 获取订单id
     *
     * @return id - 订单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单id
     *
     * @param id 订单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单编号
     *
     * @return order_no - 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单编号
     *
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
     * 获取订单总价(单位：元)
     *
     * @return total_price - 订单总价(单位：元)
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置订单总价(单位：元)
     *
     * @param totalPrice 订单总价(单位：元)
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取收货地址
     *
     * @return detail_address - 收货地址
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 设置收货地址
     *
     * @param detailAddress 收货地址
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    /**
     * 获取收货人姓名
     *
     * @return receiver_name - 收货人姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置收货人姓名
     *
     * @param receiverName 收货人姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取收货人手机号
     *
     * @return receiver_phone - 收货人手机号
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 设置收货人手机号
     *
     * @param receiverPhone 收货人手机号
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取订单状态：100:未支付；200:已取消；300:待发货；400:待收货；500:已签收
     *
     * @return order_status - 订单状态：100:未支付；200:已取消；300:待发货；400:待收货；500:已签收
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态：100:未支付；200:已取消；300:待发货；400:待收货；500:已签收
     *
     * @param orderStatus 订单状态：100:未支付；200:已取消；300:待发货；400:待收货；500:已签收
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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
     * 获取附言
     *
     * @return note - 附言
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置附言
     *
     * @param note 附言
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取发货时间
     *
     * @return deliver_time - 发货时间
     */
    public Date getDeliverTime() {
        return deliverTime;
    }

    /**
     * 设置发货时间
     *
     * @param deliverTime 发货时间
     */
    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * 获取是否评价：1：是，0：否
     *
     * @return is_evaluate - 是否评价：1：是，0：否
     */
    public Boolean getIsEvaluate() {
        return isEvaluate;
    }

    /**
     * 设置是否评价：1：是，0：否
     *
     * @param isEvaluate 是否评价：1：是，0：否
     */
    public void setIsEvaluate(Boolean isEvaluate) {
        this.isEvaluate = isEvaluate;
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