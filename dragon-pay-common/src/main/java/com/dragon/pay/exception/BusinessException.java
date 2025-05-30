package com.dragon.pay.exception;

import com.dragon.pay.enums.IResponseEnum;

/**
 * @author 赌狗
 * @since 2025-05-24 12:24
 */
public class BusinessException extends  BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
