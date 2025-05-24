package com.dragon.pay.enums;

import com.dragon.pay.assertion.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 赌狗
 * @since 2025-05-24 12:36
 */

@Getter
@AllArgsConstructor
public enum UserBusinessResponseEnum implements BusinessExceptionAssert {
    USER_HAS_REGISTER(6002, "用户已经注册"),
    USER_NOT_FOUND(6003, "用户未找到"),
    SA_LOGIN_FAIL(6004, "登录认证失败"),;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}
