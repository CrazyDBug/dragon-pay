package com.dragon.pay.enums;

import com.dragon.pay.assertion.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商户业务异常枚举
 */
@Getter
@AllArgsConstructor
public enum MerchantBusinessResponseEnum implements BusinessExceptionAssert {
    PHONE_HAS_REGISTER(8001, "手机号已注册"),
    PHONE_NOT_REGISTER(8002, "手机号未注册"),
    CODE_NOT_EXIST(8003, "验证码不存在或已过期"),
    CODE_IS_ERROR(8004, "验证码错误"),
    PASSWORD_NOT_NULL(8005, "密码不能为空"),
    PASSWORD_ERROR(8006, "密码错误"),
    ACCOUNT_IS_DISABLED(8007, "账户被禁用"),
    SA_LOGIN_FAIL(8008, "认证失败"),;;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}