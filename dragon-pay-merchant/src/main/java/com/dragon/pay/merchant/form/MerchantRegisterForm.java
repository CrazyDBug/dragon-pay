package com.dragon.pay.merchant.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author 赌狗
 * @since 2025-05-25 10:27
 */
@Data
@Schema(description = "商户注册表单")
public class MerchantRegisterForm {
    @NotBlank(message = "手机号不能为空")
    @Schema(description = "手机号")
    private String phone;

    @NotBlank(message = "验证码不能为空")
    @Pattern(regexp = "^\\d{6}$", message = "验证码必须是6位数字")
    @Schema(description = "验证码")
    private String code;

    @Schema(description = "密码")
    private String password;

    @NotBlank(message = "注册类型不能为空")
    @Pattern(regexp = "^(password|code)$", message = "注册类型只能是 password 或 code")
    @Schema(description = "注册类型——password/code")
    private String registerType;
}
