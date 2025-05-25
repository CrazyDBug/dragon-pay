package com.dragon.pay.user.bus.service;

import com.dragon.pay.user.bus.form.LoginForm;
import com.dragon.pay.user.bus.form.RegisterUserForm;
import com.dragon.pay.model.Result;

/**
 * @author 赌狗
 * @since 2025-05-24 10:37
 */
public interface UserService {
    public Result registerUser(RegisterUserForm form);

    public Result login(LoginForm form);
}
