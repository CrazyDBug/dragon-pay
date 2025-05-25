package com.dragon.pay.merchant.bus.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.dragon.pay.enums.MerchantBusinessResponseEnum;
import com.dragon.pay.enums.UserBusinessResponseEnum;
import com.dragon.pay.merchant.bus.feign.MerchantAccountApi;
import com.dragon.pay.merchant.bus.form.MerchantLoginForm;
import com.dragon.pay.merchant.bus.form.MerchantRegisterForm;
import com.dragon.pay.merchant.bus.form.SendCodeForm;
import com.dragon.pay.merchant.bus.service.MerchantAccountService;
import com.dragon.pay.merchant.bus.vo.Account;
import com.dragon.pay.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 商户登录账户表 服务实现类
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-25
 */
@Slf4j
@Service
public class MerchantAccountServiceImpl implements MerchantAccountService {

    @Autowired
    private MerchantAccountApi merchantAccountApi;

    /*
     * 商户注册
     */
    @Override
    public Result register(MerchantRegisterForm form) {
        Result result = merchantAccountApi.register(form);
        return loginSaToken(result);
    }

    @Override
    public Result login(MerchantLoginForm form) {
        Result result = merchantAccountApi.login(form);
        return loginSaToken(result);
    }


    @Override
    public Result sendCode(SendCodeForm form) {
        return merchantAccountApi.sendCode(form);
    }

    // todo 这么设计可能存在问题——注册处理——后续考虑调整业务逻辑
    public Result loginSaToken(Result<String> r) {
        if (StrUtil.isEmpty(r.getData())) return r;
        StpUtil.login(Long.parseLong(r.getData()));
        String token = StpUtil.getTokenInfo().getTokenValue();
        MerchantBusinessResponseEnum.SA_LOGIN_FAIL.assertNotEmpty(token);
        return new Result(new Account(token));
    }

}
