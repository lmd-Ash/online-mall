package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sku_apply")
public class SkuApply extends BaseEntity {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品skuid
     */
    @Column(name = "sku_id")
    private Integer skuId;

    /**
     * 描述
     */
    private String content;

    /**
     * 操作类型 100：入库；200：出库
     */
    private Integer type;

    /**
     * 操作的商品数量
     */
    @Column(name = "sku_num")
    private Integer skuNum;

    /**
     * 状态  100：待审批，200：通过，300：驳回
     */
    private Integer status;

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
     * 审批时间
     */
    @Column(name = "approval_time")
    private Date approvalTime;

    /**
     * 审批人
     */
    @Column(name = "approval_user_id")
    private Integer approvalUserId;

    /**
     * 是否可用，1：可用，0：不可用
     */
    @Column(name = "is_available")
    private Boolean isAvailable;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品skuid
     *
     * @return sku_id - 商品skuid
     */
    public Integer getSkuId() {
        return skuId;
    }

    /**
     * 设置商品skuid
     *
     * @param skuId 商品skuid
     */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取描述
     *
     * @return content - 描述
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置描述
     *
     * @param content 描述
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取操作类型 100：入库；200：出库
     *
     * @return type - 操作类型 100：入库；200：出库
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置操作类型 100：入库；200：出库
     *
     * @param type 操作类型 100：入库；200：出库
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取操作的商品数量
     *
     * @return sku_num - 操作的商品数量
     */
    public Integer getSkuNum() {
        return skuNum;
    }

    /**
     * 设置操作的商品数量
     *
     * @param skuNum 操作的商品数量
     */
    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    /**
     * 获取状态  100：待审批，200：通过，300：驳回
     *
     * @return status - 状态  100：待审批，200：通过，300：驳回
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态  100：待审批，200：通过，300：驳回
     *
     * @param status 状态  100：待审批，200：通过，300：驳回
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取审批时间
     *
     * @return approval_time - 审批时间
     */
    public Date getApprovalTime() {
        return approvalTime;
    }

    /**
     * 设置审批时间
     *
     * @param approvalTime 审批时间
     */
    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    /**
     * 获取审批人
     *
     * @return approval_user_id - 审批人
     */
    public Integer getApprovalUserId() {
        return approvalUserId;
    }

    /**
     * 设置审批人
     *
     * @param approvalUserId 审批人
     */
    public void setApprovalUserId(Integer approvalUserId) {
        this.approvalUserId = approvalUserId;
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