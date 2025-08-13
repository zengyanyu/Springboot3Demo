package com.example.controller;

import com.example.bean.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Person控制器", description = "Person控制器描述")
public class PersonController {

    @GetMapping("/getPerson")
    @Operation(summary = "获取人员信息", description = "返回xml格式的数据")
    public Person getPerson() {
        Person person = new Person();
        person.setId(1L);
        person.setUsername("飞雪");
        person.setEmail("1194314874@qq.com");
        person.setAge(18);
        return person;

        /**
         * 注意：要在配置文件中开启参数内容协商，访问默认在地址栏后面添加xxx?format=json/xml
         * format的名称也可以通过parameter-name参数进行修改
         *
         * http://localhost:8081/getPerson?format=json
         * 返回：{"id":1,"username":"飞雪","email":"1194314874@qq.com","age":18}
         *
         * http://localhost:8081/getPerson?format=xml
         * 返回：
         *  <Person>
         *      <id>1</id>
         *      <username>飞雪</username>
         *      <email>1194314874@qq.com</email>
         *      <age>18</age>
         *  </Person>
         */
    }

    @GetMapping("/getPersonByYamlData")
    @Operation(summary = "获取人员信息(返回YAML格式数据)", description = "返回YAML格式数据")
    public String getPersonByYamlData() throws JsonProcessingException {
        Person person = new Person();
        person.setId(1L);
        person.setUsername("飞雪");
        person.setEmail("1194314874@qq.com");
        person.setAge(18);

        // 创建工厂的时候，禁用一种文档开始标记特性（ 生成的yaml的开始就不会有---开始了；）
//        YAMLFactory factory = new YAMLFactory();
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper objectMapper = new ObjectMapper(factory);
        String s = objectMapper.writeValueAsString(person);
        return s;
    }

}
