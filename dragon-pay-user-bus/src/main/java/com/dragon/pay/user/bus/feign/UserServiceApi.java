package com.dragon.pay.user.bus.feign;

import com.dragon.pay.user.bus.form.LoginForm;
import com.dragon.pay.user.bus.form.RegisterUserForm;
import com.dragon.pay.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 赌狗
 * @since 2025-05-24 11:04
 */
@FeignClient(value = "dragon-pay-user")
public interface UserServiceApi {
    @PostMapping("/user/register")
    public Result registerCustomer(RegisterUserForm form);

    @PostMapping("/user/login")
    public Result login(LoginForm form);

}