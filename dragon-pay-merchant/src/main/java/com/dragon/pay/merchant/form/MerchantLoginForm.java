package com.dragon.pay.merchant.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(description = "商户登录表单")
public class MerchantLoginForm {
    
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    @Schema(description = "手机号")
    private String phone;

    @NotBlank(message = "验证码不能为空")
    @Pattern(regexp = "^\\d{6}$", message = "验证码必须是6位数字")
    @Schema(description = "验证码")
    private String code;

    @Schema(description = "密码")
    private String password;

    @NotBlank(message = "登录类型不能为空")
    @Pattern(regexp = "^(password|code)$", message = "登录类型只能是password或code")
    @Schema(description = "登录类型：password-密码登录，code-验证码登录", defaultValue = "code")
    private String loginType = "code";
} 