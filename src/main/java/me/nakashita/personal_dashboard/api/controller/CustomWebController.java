package me.nakashita.personal_dashboard.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomWebController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
