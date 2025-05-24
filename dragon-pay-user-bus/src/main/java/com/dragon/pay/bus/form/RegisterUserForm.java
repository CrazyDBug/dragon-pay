package com.dragon.pay.bus.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 赌狗
 * @since 2025-05-24 10:57
 */
@Data
@Schema(description = "注册新客户")
public class RegisterUserForm {

    @NotBlank(message = "用户名不能为空")
    @Schema(description = "用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;
}
