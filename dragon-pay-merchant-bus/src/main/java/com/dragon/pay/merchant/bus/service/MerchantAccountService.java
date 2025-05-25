package com.dragon.pay.merchant.bus.service;

import com.dragon.pay.merchant.bus.form.MerchantLoginForm;
import com.dragon.pay.merchant.bus.form.MerchantRegisterForm;
import com.dragon.pay.merchant.bus.form.SendCodeForm;
import com.dragon.pay.model.Result;

/**
 * <p>
 * 商户登录账户表 服务类
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-25
 */
public interface MerchantAccountService {
    /**
     * 商户注册
     * @param form 注册表单
     * @return 注册结果
     */
    public Result register(MerchantRegisterForm form);

    /**
     * 发送验证码
     * @param form 发送验证码表单
     * @return 验证码
     */
    public Result sendCode(SendCodeForm form);

    /**
     * 商户登录
     * @param form 登录表单
     * @return
     */
    public Result login(MerchantLoginForm form);
}
