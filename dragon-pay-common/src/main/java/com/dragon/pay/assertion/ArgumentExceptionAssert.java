package com.dragon.pay.assertion;

import cn.hutool.core.util.ArrayUtil;
import com.dragon.pay.enums.IResponseEnum;
import com.dragon.pay.exception.ArgumentException;
import com.dragon.pay.exception.BaseException;

import java.text.MessageFormat;

/**
 * @author 赌狗
 * @since 2025-05-24 12:26
 */

public interface ArgumentExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = this.getMessage();
        if (ArrayUtil.isNotEmpty(args)) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new ArgumentException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = this.getMessage();
        if (ArrayUtil.isNotEmpty(args)) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new ArgumentException(this, args, msg, t);
    }

}

