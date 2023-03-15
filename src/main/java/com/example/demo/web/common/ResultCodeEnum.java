package com.example.demo.web.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResultCodeEnum {
    SUCCESS(0, "成功"),
    FAILED(1, "失败");

    private final Integer code;

    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
