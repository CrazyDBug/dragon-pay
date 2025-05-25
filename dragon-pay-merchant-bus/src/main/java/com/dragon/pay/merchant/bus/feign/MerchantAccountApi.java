package com.dragon.pay.merchant.bus.feign;

import com.dragon.pay.merchant.bus.form.MerchantLoginForm;
import com.dragon.pay.merchant.bus.form.MerchantRegisterForm;
import com.dragon.pay.merchant.bus.form.SendCodeForm;
import com.dragon.pay.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 赌狗
 * @since 2025-05-25 19:35
 */
@FeignClient(value = "dragon-pay-merchant")
public interface MerchantAccountApi {
    @PostMapping("/merchant/account/register")
    public Result register(MerchantRegisterForm form) ;

    @PostMapping("/merchant/account/login")
    public Result login(MerchantLoginForm form);

    @PostMapping("/merchant/account/sendCode")
    public Result sendCode(SendCodeForm form) ;

}
