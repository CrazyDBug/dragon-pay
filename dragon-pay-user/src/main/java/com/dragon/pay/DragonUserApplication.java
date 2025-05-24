package com.dragon.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 赌狗
 * @since 2025-05-23 23:28
 */
@SpringBootApplication(scanBasePackages = "com.dragon.pay")
@MapperScan("com.dragon.pay.user.mapper")
public class DragonUserApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DragonUserApplication.class).run(args);
    }
}