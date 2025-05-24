package com.dragon.pay.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-24
 */
@Getter
@Setter
@ToString
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID（雪花ID/自增ID）
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 密码加密盐
     */
    private String salt;

    /**
     * 用户状态（0-正常，1-禁用）
     */
    private Boolean status;

    /**
     * 逻辑删除标志（0-正常，1-删除）
     */
    @TableLogic
    private Boolean delFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
