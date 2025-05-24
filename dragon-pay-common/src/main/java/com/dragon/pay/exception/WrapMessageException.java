package com.dragon.pay.exception;

/**
 * @author 赌狗
 * @since 2025-05-24 12:24
 */
public class WrapMessageException extends RuntimeException {

    public WrapMessageException(String message) {
        super(message);
    }

    public WrapMessageException(String message, Throwable cause) {
        super(message, cause);
    }

}