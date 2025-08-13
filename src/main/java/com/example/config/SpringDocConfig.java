package com.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "项目API文档",
        version = "1.0",
        description = "SpringBoot项目接口文档"
))
public class SpringDocConfig {

    @Bean
    public GroupedOpenApi userGroup() {
        // 使用路径匹配方式：仅包含 /api/product/** 下的接口
        return GroupedOpenApi.builder()
                .group("系统模块")
                .pathsToMatch("/**") // 路径匹配
                .build();
    }
}
