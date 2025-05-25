package com.dragon.pay.merchant.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 赌狗
 * @since 2025-05-25 10:10
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients("com.dragon.pay.*")
@ComponentScan("com.dragon.*")
public class DragonPayMerchantBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(DragonPayMerchantBusApplication.class, args);
    }
}
