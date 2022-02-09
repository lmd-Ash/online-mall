package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "order_detail")
public class OrderDetail extends BaseEntity {
    /**
     * 订单详情id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品售价
     */
    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    /**
     * 商品数量
     */
    @Column(name = "product_num")
    private Integer productNum;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否可用，1：可用，0：不可用
     */
    @Column(name = "is_available")
    private Boolean isAvailable;

    /**
     * 获取订单详情id
     *
     * @return id - 订单详情id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单详情id
     *
     * @param id 订单详情id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
     * 获取商品售价
     *
     * @return selling_price - 商品售价
     */
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    /**
     * 设置商品售价
     *
     * @param sellingPrice 商品售价
     */
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
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