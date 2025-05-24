package com.dragon.pay.bus.controller;

import com.dragon.pay.bus.form.LoginForm;
import com.dragon.pay.bus.form.RegisterUserForm;
import com.dragon.pay.bus.service.UserService;
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
 * @author 赌狗
 * @since 2025-05-24 10:28
 */
@RestController
@RequestMapping("/user")
@Tag(name = "UserController", description = "用户模块前置服务接口")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(summary = "注册新用户")
    public Result registerNewCustomer(@RequestBody @Valid RegisterUserForm form) {
        return userService.registerUser(form);
    }

    @PostMapping("/login")
    @Operation(summary = "登陆系统")
    public Result login(@RequestBody @Valid LoginForm form){
        return userService.login(form);
    }
}