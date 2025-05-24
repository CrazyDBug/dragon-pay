CREATE TABLE `sys_user` (
                            `id` BIGINT NOT NULL COMMENT '主键ID（雪花ID/自增ID）',
                            `username` VARCHAR(64) NOT NULL COMMENT '登录用户名',
                            `realname` VARCHAR(64) DEFAULT NULL COMMENT '真实姓名',
                            `password` VARCHAR(255) NOT NULL COMMENT '加密后的密码',
                            `salt` VARCHAR(64) DEFAULT NULL COMMENT '密码加密盐',
                            `status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '用户状态（0-正常，1-禁用）',
                            `del_flag` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除标志（0-正常，1-删除）',
                            `create_by` VARCHAR(64) DEFAULT NULL COMMENT '创建人',
                            `update_by` VARCHAR(64) DEFAULT NULL COMMENT '更新人',
                            `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `uk_username` (`username`) COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户表';
