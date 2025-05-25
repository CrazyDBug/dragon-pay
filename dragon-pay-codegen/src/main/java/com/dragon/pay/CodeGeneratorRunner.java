package com.dragon.pay;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.fill.Column;
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
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .idType(IdType.ASSIGN_ID)
                            .logicDeleteColumnName("del_flag") // ✅ 设置逻辑删除字段（数据库列名）
                            .logicDeletePropertyName("delFlag") // ✅ 设置逻辑删除字段（实体属性名）
                            .addTableFills(
                                    new Column("create_time", FieldFill.INSERT),
                                    new Column("update_time", FieldFill.INSERT_UPDATE),
                                    new Column("del_flag", FieldFill.INSERT)
                            );
                })
                .execute();
    }
}
