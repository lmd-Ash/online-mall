package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class User extends BaseEntity implements Serializable {
    /**
     * 员工id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 员工姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 登录账号
     */
    @Column(name = "login_name")
    private String loginName;


    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private Integer createUserId;


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
     * 获取员工id
     *
     * @return id - 员工id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置员工id
     *
     * @param id 员工id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取员工姓名
     *
     * @return user_name - 员工姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置员工姓名
     *
     * @param userName 员工姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取登录账号
     *
     * @return login_name - 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录账号
     *
     * @param loginName 登录账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * ��ȡ������id
     *
     * @return create_user_id - ������id
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
     * ��ȡ�޸���id
     *
     * @return update_user_id - �޸���id
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