package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "用户信息Dto对象")
public class UserInfoDto {

    @Schema(description = "用户名称")
    private String username;

    @Schema(description = "密码")
    private String password;
}
