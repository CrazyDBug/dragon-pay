package com.dragon.pay.enums;

import com.dragon.pay.assertion.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户业务异常枚举
 */
@Getter
@AllArgsConstructor
public enum UserBusinessResponseEnum implements BusinessExceptionAssert {
    USER_HAS_REGISTER(6002, "用户已经注册"),
    USER_NOT_FOUND(6003, "用户未找到"),
    SA_LOGIN_FAIL(6004, "认证失败"),;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}