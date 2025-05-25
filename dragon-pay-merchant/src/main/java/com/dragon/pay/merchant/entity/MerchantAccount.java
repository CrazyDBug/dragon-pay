package com.dragon.pay.merchant.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商户登录账户表
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-25
 */
@Getter
@Setter
@ToString
@Builder
@TableName("merchant_account")
public class MerchantAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID（雪花ID/自增ID或雪花算法ID）
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 手机号，唯一，作为登录凭证
     */
    private String phone;

    /**
     * 登录用户名（昵称），非唯一，支持为空
     */
    private String username;

    /**
     * 真实姓名，非必填
     */
    private String realname;

    /**
     * 加密后的密码（可为空，支持验证码登录场景）
     */
    private String password;

    /**
     * 账号状态（0-正常，1-禁用）
     */
    private Boolean status;

    /**
     * 逻辑删除标志（0-正常，1-删除）
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean delFlag;

    /**
     * 创建人账号或ID
     */
    private String createBy;

    /**
     * 更新人账号或ID
     */
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
