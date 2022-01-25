package com.onlinemall.exception;

import com.onlinemall.common.Msg;
import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException() {
        super(Msg.TEXT_SYSTEM_FAIL);
        this.code = Msg.SYSTEM_FAIL;
    }

    public CustomException(String msg) {
        super(msg);
        this.code = Msg.SYSTEM_FAIL;
    }

    public CustomException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
