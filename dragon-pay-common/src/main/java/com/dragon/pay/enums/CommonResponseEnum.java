package com.dragon.pay.enums;

import com.dragon.pay.assertion.CommonExceptionAssert;
import com.dragon.pay.exception.BaseException;
import com.dragon.pay.model.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 赌狗
 * @since 2025-05-24 12:28
 */

@Getter
@AllArgsConstructor
public enum CommonResponseEnum implements CommonExceptionAssert {
    /**
     * 成功
     */
    SUCCESS(100, "SUCCESS"),
    /**
     * 服务器繁忙，请稍后重试
     */
    /**
     * 服务器异常，无法识别的异常，尽可能对通过判断减少未定义异常抛出
     */
    SERVER_ERROR(9002, "网络异常"),


    /**
     * mq消息收发错误
     */



    /**
     * 参数校验异常
     */
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    /**
     * 校验返回结果是否成功
     * @param response 远程调用的响应
     */
    public static void assertSuccess(BaseResponse response) {
        SERVER_ERROR.assertNotNull(response);
        int code = response.getCode();
        if (CommonResponseEnum.SUCCESS.getCode() != code) {
            String msg = response.getMessage();
            throw new BaseException(code, msg);
        }
    }
}