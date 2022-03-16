package com.onlinemall.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static com.onlinemall.common.StatisRegexp.PHONE_REGEXP;

@Data
@EqualsAndHashCode(callSuper = true)
public class BuyerReq extends BaseReq implements Serializable {
    /**
     * 商户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    /**
     * 商户姓名
     */
    @NotBlank(message = "请填写用户名", groups = Insert.class)
    private String buyerName;

    /**
     * 手机号
     */
    @NotBlank(message = "请填写手机号", groups = {Insert.class, Update.class})
    @Pattern(regexp = PHONE_REGEXP, message = "请输入正确的手机号", groups = Insert.class)
    private String phone;

    /**
     * 登录密码
     */
    @NotBlank(message = "请填写密码", groups = {Insert.class, Update.class})
    private String password;

}