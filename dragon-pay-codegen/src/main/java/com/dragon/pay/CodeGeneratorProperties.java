package com.dragon.pay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author 赌狗
 * @since 2025-05-24 00:36
 */
@Data
@ConfigurationProperties(prefix = "code-generator")
public class CodeGeneratorProperties {
    private String author;
    private String outputDir;
    private String parentPackage;
    private String moduleName;
    private List<String> includeTables;
    private String tablePrefix;
    private Db db;

    @Data
    public static class Db {
        private String url;
        private String username;
        private String password;
    }
}

