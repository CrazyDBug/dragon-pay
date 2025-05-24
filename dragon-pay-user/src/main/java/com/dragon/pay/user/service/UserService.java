package com.dragon.pay.user.service;

import com.dragon.pay.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dragon.pay.user.form.LoginForm;
import com.dragon.pay.user.form.RegisterUserForm;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-24
 */
public interface UserService extends IService<User> {
    public String registerCustomer(RegisterUserForm form);
    public String login(LoginForm form);
}
