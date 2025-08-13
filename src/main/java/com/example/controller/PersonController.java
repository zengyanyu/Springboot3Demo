package com.example.controller;

import com.example.bean.Person;
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
}
