package com.nakashita.personaldashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/api")
    public String renderHomePage(){
        return new HomePageHtml().toString();
    }

    @GetMapping("/bla")
    public String testReact(){
        return "HelloWorld";
    }
}
