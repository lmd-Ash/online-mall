package com.onlinemall.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.onlinemall.tkmybatis.BaseEntity;
import com.onlinemall.tkmybatis.Insert;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static com.onlinemall.common.StatisRegexp.PHONE_REGEXP;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderReq extends BaseReq implements Serializable {
    /**
     * 订单id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 商户id
     */
    private Integer buyerId;

    /**
     * 商品id
     */
    @NotNull(message = "请选择购买商品", groups = Insert.class)
    private Integer productId;

    /**
     * 商品数量
     */
    @NotNull(message = "请选择购买数量", groups = Insert.class)
    private Integer productNum;

    /**
     * 收货地址
     */
    @NotBlank(message = "请填写收货地址", groups = Insert.class)
    private String detailAddress;

    /**
     * 收货人姓名
     */
    @NotBlank(message = "请填写收货人姓名", groups = Insert.class)
    private String receiverName;

    /**
     * 收货人手机号
     */
    @NotBlank(message = "请填写收货人手机号", groups = Insert.class)
    @Pattern(regexp = PHONE_REGEXP, message = "请输入正确的手机号", groups = Insert.class)
    private String receiverPhone;

    /**
     * 附言
     */
    private String note;


}