package com.example.controller;

import com.example.dto.UserInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "用户信息控制器", description = "用户信息控制器描述")
public class UserInfoController {

    @GetMapping("/getUserInfo")
    @Operation(summary = "获取用户信息", description = "获取用户信息描述")
    public UserInfoDto getUserInfo() {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername("admin");
        userInfoDto.setPassword("123456");
        return userInfoDto;
    }

}
