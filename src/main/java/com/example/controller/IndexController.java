package com.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Tag(name = "Index控制器", description = "Index控制器描述")
public class IndexController {

    @GetMapping("toIndex")
    @Operation(summary = "跳转到Index页面", description = "跳转到Index页面")
    public String toIndex(Model model) {
        model.addAttribute("projectName", "springboot3Demo");
        model.addAttribute("springbootVersion", "3.0.5");
        return "index";
    }
}
