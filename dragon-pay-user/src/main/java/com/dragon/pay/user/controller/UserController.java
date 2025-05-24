package com.dragon.pay.user.controller;

import cn.hutool.core.bean.BeanUtil;
import com.dragon.pay.model.Result;
import com.dragon.pay.user.form.LoginForm;
import com.dragon.pay.user.form.RegisterUserForm;
import com.dragon.pay.user.service.UserService;
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
 * 用户表 前端控制器
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-24
 */
@RestController
@RequestMapping("/user")
@Tag(name = "UserController", description = "用户核心业务处理接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(summary = "新用户注册接口")
    public Result<String> registerCustomer(@RequestBody @Valid RegisterUserForm form) {
        return new Result<>(userService.registerCustomer(form));
    }

    @PostMapping("/login")
    @Operation(summary = "登录接口")
    public Result login(@RequestBody @Valid LoginForm form) {
        return new Result(userService.login(form));
    }

}
