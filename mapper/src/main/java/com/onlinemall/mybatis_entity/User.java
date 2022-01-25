package com.onlinemall.mybatis_entity;

import com.onlinemall.tkmybatis.BaseEntity;
import java.util.Date;
import javax.persistence.*;

public class User extends BaseEntity {
    /**
     * Ա��id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Ա������
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * ��¼����
     */
    private String password;

    /**
     * ��¼�˺�
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * ����ʱ��
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * ������id
     */
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * �޸�ʱ��
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * �޸���id
     */
    @Column(name = "update_user_id")
    private Integer updateUserId;

    /**
     * �Ƿ���ã�1�����ã�0��������
     */
    @Column(name = "is_available")
    private Boolean isAvailable;

    /**
     * ��ȡԱ��id
     *
     * @return id - Ա��id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ����Ա��id
     *
     * @param id Ա��id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ��ȡԱ������
     *
     * @return user_name - Ա������
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ����Ա������
     *
     * @param userName Ա������
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * ��ȡ��¼����
     *
     * @return password - ��¼����
     */
    public String getPassword() {
        return password;
    }

    /**
     * ���õ�¼����
     *
     * @param password ��¼����
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ��ȡ��¼�˺�
     *
     * @return login_name - ��¼�˺�
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * ���õ�¼�˺�
     *
     * @param loginName ��¼�˺�
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return create_time - ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ���ô���ʱ��
     *
     * @param createTime ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * ���ô�����id
     *
     * @param createUserId ������id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * ��ȡ�޸�ʱ��
     *
     * @return update_time - �޸�ʱ��
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * �����޸�ʱ��
     *
     * @param updateTime �޸�ʱ��
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
     * �����޸���id
     *
     * @param updateUserId �޸���id
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * ��ȡ�Ƿ���ã�1�����ã�0��������
     *
     * @return is_available - �Ƿ���ã�1�����ã�0��������
     */
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * �����Ƿ���ã�1�����ã�0��������
     *
     * @param isAvailable �Ƿ���ã�1�����ã�0��������
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}