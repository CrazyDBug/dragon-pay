package com.dragon.pay.user.bus.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 赌狗
 * @since 2025-05-24 10:58
 */
@Data
@Schema(description = "用户登陆系统")
public class LoginForm {

    @NotBlank(message = "用户名不能为空")
    @Schema(description = "用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;
}