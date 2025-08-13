package com.example.bean;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement // 可以写出为xml文档
@Getter
@Setter
public class Person {

    private Long id;

    private String username;

    private String email;

    private Integer age;
}
