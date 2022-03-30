package me.nakashita.personal_dashboard.adapters.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/login-form")
    public String login() {
        return "login";
    }

}
