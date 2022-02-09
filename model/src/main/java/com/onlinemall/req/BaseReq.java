package com.onlinemall.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * 基础查询类
 *
 * @author lmd
 * @version 1.0
 * @date 2019-09-23 23:25
 */
@Data
public class BaseReq implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 是否可用 0：否，1：是
     */
    private Boolean isAvailable;

    /**
     * 当前页
     */
    private Integer page = 1;

    public Integer getPage() {
        return Objects.isNull(page) ? 0 : page < 1 ? 0 : page - 1;
    }

    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    /**
     * 排序条件
     */
    private String clause;

    public void setAvailable(Boolean available) {
        if (Objects.isNull(available)) {
            this.isAvailable = true;
        } else {
            this.isAvailable = available;
        }
    }
}
