package com.dragon.pay.user.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 赌狗
 * @since 2025-05-24 10:17
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients("com.dragon.pay.*")
@ComponentScan("com.dragon.*")
public class DragonPayUserBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(DragonPayUserBusApplication.class, args);
    }
}
