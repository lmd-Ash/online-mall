package com.onlinemall.enmu;

/**
 * 其他支付订单状态文字说明枚举
 *
 * @auther lmd
 * @date 2020/6/24
 * @Company 晶粮
 */
public enum OrderEnum {
    /**
     * 待付款
     */
    TO_BE_DELIVERED(100, "待发货"),
    /**
     * 已完成
     */
    SUCCESS(200, "已完成"),
    ;


    public Integer code;
    public String view;

    public Integer getCode() {
        return code;
    }

    public String getView() {
        return view;
    }

    OrderEnum(Integer code, String view) {
        this.code = code;
        this.view = view;
    }

    public static String getOrderView(Integer code) {
        for (OrderEnum orderEnum : values()) {
            if (code.equals(orderEnum.code)) {
                return orderEnum.view;
            }
        }
        return "未知";
    }
}
