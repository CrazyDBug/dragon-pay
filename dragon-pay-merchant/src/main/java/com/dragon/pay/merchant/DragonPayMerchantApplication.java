package com.dragon.pay.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 商户服务启动类
 */
@SpringBootApplication
@MapperScan("com.dragon.pay.merchant.mapper")
@ComponentScan("com.dragon.pay")
public class DragonPayMerchantApplication {
    public static void main(String[] args) {
        SpringApplication.run(DragonPayMerchantApplication.class, args);
    }
} 