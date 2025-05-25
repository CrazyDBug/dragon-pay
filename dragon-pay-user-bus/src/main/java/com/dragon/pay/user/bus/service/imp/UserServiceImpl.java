package com.dragon.pay.user.bus.service.imp;

import cn.dev33.satoken.stp.StpUtil;
import com.dragon.pay.user.bus.feign.UserServiceApi;
import com.dragon.pay.user.bus.form.LoginForm;
import com.dragon.pay.user.bus.form.RegisterUserForm;
import com.dragon.pay.user.bus.service.UserService;
import com.dragon.pay.user.bus.vo.Account;
import com.dragon.pay.enums.UserBusinessResponseEnum;
import com.dragon.pay.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.StrUtil;

/**
 * @author 赌狗
 * @since 2025-05-24 10:39
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceApi userServiceApi;

    @Override
    public Result registerUser(RegisterUserForm form) {
        Result result = userServiceApi.registerCustomer(form);
        return loginSaToken(result);
    }

    @Override
    public Result login(LoginForm form) {
        Result result = userServiceApi.login(form);
        return loginSaToken(result);
    }

    public Result loginSaToken(Result<String> r) {
        if (StrUtil.isEmpty(r.getData())) return r;
        StpUtil.login(Long.parseLong(r.getData()));
        String token = StpUtil.getTokenInfo().getTokenValue();
        UserBusinessResponseEnum.SA_LOGIN_FAIL.assertNotEmpty(token);
        return new Result(new Account(token));
    }
}
