package com.dragon.pay.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 赌狗
 * @since 2025-05-24 12:32
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Result<T> extends CommonResponse<T> {

    public Result() {
        super();
    }

    public Result(T data) {
        super();
        this.data = data;
    }

    public Result(T data, String msg) {
        super();
        this.data = data;
        this.message = msg;
    }

    public Result(Throwable e) {
        super();
        this.message = e.getMessage();
        this.code = -1;
    }
}

