package com.dragon.pay;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.util.Collections;

/**
 * @author 赌狗
 * @since 2025-05-24 00:39
 */
@Component
public class CodeGeneratorRunner implements CommandLineRunner {

    @Autowired
    private CodeGeneratorProperties config;

    @Override
    public void run(String... args) {
        FastAutoGenerator.create(
                        config.getDb().getUrl(),
                        config.getDb().getUsername(),
                        config.getDb().getPassword()
                )
                .globalConfig(builder -> {
                    builder.author(config.getAuthor())
                            .outputDir(Paths.get(config.getOutputDir()).toAbsolutePath().toString())
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(config.getParentPackage())
                            .moduleName(config.getModuleName())
                            .pathInfo(Collections.singletonMap(
                                    OutputFile.xml,
                                    Paths.get("src/main/resources/mapper").toAbsolutePath().toString()));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(config.getIncludeTables())
                            .addTablePrefix(config.getTablePrefix())
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .enableLombok(); // ✅ 启用 Lombok 注解替代 Getter/Setter
                })
                .execute();
    }
}
