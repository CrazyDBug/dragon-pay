package com.dragon.pay.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 赌狗
 * @since 2025-05-24 12:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CommonResponse<T> extends BaseResponse {
    /**
     * 数据列表
     */
    protected T data;

    public CommonResponse() {
        super();
    }

    public CommonResponse(T data) {
        super();
        this.data = data;
    }
}
