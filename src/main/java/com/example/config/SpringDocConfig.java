package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI().info(new Info().title("蒾酒的demo")
                .description("这是基于Knife4j OpenApi3的测试接口文档")
                .version("1.0版本").contact(new Contact().name("蒾酒").email("000000000@qq.com")));
    }

}
