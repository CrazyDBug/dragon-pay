package com.dragon.pay.exception;

import com.dragon.pay.enums.IResponseEnum;

/**
 * @author 赌狗
 * @since 2025-05-24 12:24
 */
public class ArgumentException extends  BaseException {

    private static final long serialVersionUID = 1L;

    public ArgumentException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public ArgumentException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
