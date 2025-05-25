package com.dragon.pay.merchant.controller;

import com.dragon.pay.merchant.form.MerchantRegisterForm;
import com.dragon.pay.merchant.form.SendCodeForm;
import com.dragon.pay.merchant.form.MerchantLoginForm;
import com.dragon.pay.merchant.service.MerchantAccountService;
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
@Tag(name = "商户账户", description = "商户账户业务处理接口")
@RequestMapping("/merchant/account")
public class MerchantAccountController {
    @Autowired
    private MerchantAccountService merchantService;

    @PostMapping("/register")
    @Operation(summary = "商户注册")
    public Result<String> register(@RequestBody @Valid MerchantRegisterForm form) {
        return new Result<>(merchantService.register(form));
    }

    // 发送6位数字验证码到Redis
    @PostMapping("/sendCode")
    @Operation(summary = "发送6位数字验证码到Redis")
    public Result<String> sendCode(@RequestBody @Valid SendCodeForm form) {
        return new Result<>(merchantService.sendCode(form));
    }

    @PostMapping("/login")
    @Operation(summary = "商户登录")
    public Result<String> login(@RequestBody @Valid MerchantLoginForm form) {
        return new Result<>(merchantService.login(form));
    }
}
