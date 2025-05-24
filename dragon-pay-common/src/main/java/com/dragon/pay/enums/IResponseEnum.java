package com.dragon.pay.enums;

/**
 * @author 赌狗
 * @since 2025-05-24 12:17
 */
public interface IResponseEnum {
    /**
     * 获取返回码
     * @return 返回码
     */
    int getCode();

    /**
     * 获取返回信息
     * @return 返回信息
     */
    String getMessage();
}