CREATE TABLE `merchant_account` (
                                    `id` bigint NOT NULL COMMENT '主键ID（雪花ID/自增ID或雪花算法ID）',
                                    `phone` varchar(20) NOT NULL COMMENT '手机号，唯一，作为登录凭证',
                                    `username` varchar(64) DEFAULT NULL COMMENT '登录用户名（昵称），非唯一，支持为空',
                                    `realname` varchar(64) DEFAULT NULL COMMENT '真实姓名，非必填',
                                    `password` varchar(255) DEFAULT NULL COMMENT '加密后的密码（可为空，支持验证码登录场景）',
                                    `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '账号状态（0-正常，1-禁用）',
                                    `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志（0-正常，1-删除）',
                                    `create_by` varchar(64) DEFAULT NULL COMMENT '创建人账号或ID',
                                    `update_by` varchar(64) DEFAULT NULL COMMENT '更新人账号或ID',
                                    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商户登录账户表';

CREATE TABLE `user` (
                        `id` bigint NOT NULL COMMENT '主键ID（雪花ID/自增ID）',
                        `username` varchar(64) NOT NULL COMMENT '登录用户名',
                        `realname` varchar(64) DEFAULT NULL COMMENT '真实姓名',
                        `password` varchar(255) NOT NULL COMMENT '加密后的密码',
                        `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户状态（0-正常，1-禁用）',
                        `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志（0-正常，1-删除）',
                        `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
                        `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `uk_username` (`username`) COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';