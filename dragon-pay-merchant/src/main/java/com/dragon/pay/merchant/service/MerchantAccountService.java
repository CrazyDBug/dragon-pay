package com.dragon.pay.merchant.service;

import com.dragon.pay.merchant.entity.MerchantAccount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dragon.pay.merchant.form.MerchantLoginForm;
import com.dragon.pay.merchant.form.MerchantRegisterForm;
import com.dragon.pay.merchant.form.SendCodeForm;

/**
 * <p>
 * 商户登录账户表 服务类
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-25
 */
public interface MerchantAccountService extends IService<MerchantAccount> {
    /**
     * 商户注册
     * @param form 注册表单
     * @return 注册结果
     */
    String register(MerchantRegisterForm form);

    /**
     * 发送验证码
     * @param form 发送验证码表单
     * @return 验证码
     */
    String sendCode(SendCodeForm form);

    /**
     * 商户登录
     * @param form 登录表单
     * @return
     */
    String login(MerchantLoginForm form);
}
