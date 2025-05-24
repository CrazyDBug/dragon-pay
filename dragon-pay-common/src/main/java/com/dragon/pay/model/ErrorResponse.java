package com.dragon.pay.model;

/**
 * @author 赌狗
 * @since 2025-05-24 12:22
 */
public class ErrorResponse extends BaseResponse {

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message) {
        super(code, message);
    }
}