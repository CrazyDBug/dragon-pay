package com.dragon.pay;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 赌狗
 * @since 2025-05-23 23:01
 */
@SpringBootApplication
public class DragonMerchantApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DragonMerchantApplication.class).run(args);
    }
}
