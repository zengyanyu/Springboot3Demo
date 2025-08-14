package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("toIndex")
    public String toIndex(Model model) {
        model.addAttribute("springbootVersion", "3.0.5");
        return "index";
    }
}
