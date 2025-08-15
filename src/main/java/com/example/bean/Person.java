package com.example.bean;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Person对象")
@JacksonXmlRootElement // 可以写出为xml文档
@Getter
@Setter
public class Person {

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "用户名称")
    private String username;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "年龄")
    private Integer age;
}
