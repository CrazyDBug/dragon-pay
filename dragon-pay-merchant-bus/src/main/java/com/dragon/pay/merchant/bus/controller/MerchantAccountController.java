package com.dragon.pay.merchant.bus.controller;

import com.dragon.pay.merchant.bus.form.MerchantLoginForm;
import com.dragon.pay.merchant.bus.form.MerchantRegisterForm;
import com.dragon.pay.merchant.bus.form.SendCodeForm;
import com.dragon.pay.merchant.bus.service.MerchantAccountService;
import com.dragon.pay.model.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商户登录账户表 前端控制器
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-25
 */
@RestController
@Tag(name = "商户账户前置服务", description = "商户账户业务处理接口")
@RequestMapping("/api/merchant/account")
public class MerchantAccountController {
    @Autowired
    private MerchantAccountService merchantService;

    @PostMapping("/register")
    @Operation(summary = "商户注册")
    public Result registerMerchant(@RequestBody @Valid MerchantRegisterForm form) {
        return merchantService.register(form);
    }

    @PostMapping("/sendCode")
    @Operation(summary = "发送6位数字验证码到Redis")
    public Result sendCode(@RequestBody @Valid SendCodeForm form) {
        return merchantService.sendCode(form);
    }

    @PostMapping("/login")
    @Operation(summary = "商户登录")
    public Result login(@RequestBody @Valid MerchantLoginForm form) {
        return merchantService.login(form);
    }
}
