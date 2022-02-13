package com.onlinemall.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.onlinemall.tkmybatis.Insert;
import com.onlinemall.tkmybatis.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductTypeReq extends BaseReq implements Serializable {
    /**
     * 商品分类id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    /**
     * 商品分类名称
     */
    @NotBlank(message = "分类名不能为空", groups = {Insert.class, Update.class})
    private String productTypeName;

}