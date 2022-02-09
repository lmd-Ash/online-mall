package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "img_urls")
public class ImgUrls extends BaseEntity {
    /**
     * 图片id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 图片类型：100:商品分类，200:商品
     */
    private Integer type;

    /**
     * 图片对应的具体id
     */
    @Column(name = "type_id")
    private Integer typeId;

    /**
     * 图片url路径
     */
    @Column(name = "img_url")
    private String imgUrl;

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
     * 获取图片id
     *
     * @return id - 图片id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置图片id
     *
     * @param id 图片id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取图片类型：100:商品分类，200:商品
     *
     * @return type - 图片类型：100:商品分类，200:商品
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置图片类型：100:商品分类，200:商品
     *
     * @param type 图片类型：100:商品分类，200:商品
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取图片对应的具体id
     *
     * @return type_id - 图片对应的具体id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 设置图片对应的具体id
     *
     * @param typeId 图片对应的具体id
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取图片url路径
     *
     * @return img_url - 图片url路径
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片url路径
     *
     * @param imgUrl 图片url路径
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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