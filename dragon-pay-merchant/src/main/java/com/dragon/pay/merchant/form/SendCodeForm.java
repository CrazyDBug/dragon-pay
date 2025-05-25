package com.dragon.pay.merchant.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(description = "发送验证码请求表单")
public class SendCodeForm {
    
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    @Schema(description = "手机号")
    private String phone;

    @NotBlank(message = "验证码用途不能为空")
    @Pattern(regexp = "^(register|login)$", message = "验证码用途只能是register或login")
    @Schema(description = "验证码用途：register-注册，login-登录", defaultValue = "register")
    private String purpose = "register";
} 