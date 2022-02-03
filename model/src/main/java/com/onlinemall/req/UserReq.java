package com.onlinemall.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.onlinemall.tkmybatis.Insert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lmd
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserReq extends BaseReq implements Serializable {
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "请填写用户名", groups = Insert.class)
    private String userName;

    /**
     * 用户名
     */
    @NotBlank(message = "请填写登录名", groups = Insert.class)
    private String loginName;

    /**
     * 密码
     */
    @NotBlank(message = "请填写密码", groups = Insert.class)
    private String password;

}