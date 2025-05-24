package com.dragon.pay.model;

/**
 * @author 赌狗
 * @since 2025-05-24 12:22
 */
public class CommonResult {
    private boolean success;
    private String result;

    public CommonResult() {
    }

    public CommonResult(boolean success, String result) {
        this.success = success;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getResult() {
        return result;
    }
}
