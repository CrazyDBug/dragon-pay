package com.dragon.pay;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author 赌狗
 * @description: 代码生成器
 * @since 2025-05-24 00:32
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableConfigurationProperties(CodeGeneratorProperties.class)
public class DragonCodeGenerationApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DragonCodeGenerationApplication.class).run(args);
    }
}
