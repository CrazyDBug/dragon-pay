package com.dragon.pay.model;

import com.dragon.pay.enums.IResponseEnum;
import com.dragon.pay.enums.CommonResponseEnum;
import lombok.Data;

/**
 * @author 赌狗
 * @since 2025-05-24 12:14
 */
@Data
public class BaseResponse {
    /**
     * 返回码
     */
    protected int code;
    /**
     * 返回消息
     */
    protected String message;

    public BaseResponse() {
        // 默认创建成功的回应
        this(CommonResponseEnum.SUCCESS);
    }

    public BaseResponse(IResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage());
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

}