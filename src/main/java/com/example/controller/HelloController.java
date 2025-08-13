package com.example.controller;

import com.example.dto.UserInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello控制器", description = "Hello控制器")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @Operation(summary = "hello方法", description = "hello方法描述")
    public String hello() {
        for (int i = 0; i < 1000; i++) {
            logger.info("Hello Spring boot 3===========" + i);
        }
        return "hello Spring boot 3";
    }

    @GetMapping("/getUserInfo")
    @Operation(summary = "获取用户信息", description = "获取用户信息描述")
    public UserInfoDto getUserInfo() {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername("admin");
        userInfoDto.setPassword("123456");
        return userInfoDto;
    }

}
