package com.example.config;

import com.example.bean.Cat;
import com.example.bean.Dog;
import com.example.bean.Sheep;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// 表示这个一个配置类
@SpringBootConfiguration
@EnableConfigurationProperties(Sheep.class)
public class AppConfig {

    // 如果存在这个类，创建Cat对象
    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01() {
        return new Cat();
    }

    // 如果不存在这个类，就创建Dog对象
    @ConditionalOnMissingClass("com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01() {
        return new Dog();
    }
}
