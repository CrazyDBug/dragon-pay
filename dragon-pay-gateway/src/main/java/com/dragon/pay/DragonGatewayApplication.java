package com.dragon.pay;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 赌狗
 * @since 2025-05-22 22:40
 */
@SpringBootApplication
public class DragonGatewayApplication{
    public static void main(String[] args) {
        new SpringApplicationBuilder(DragonGatewayApplication.class).run(args);
    }
}
