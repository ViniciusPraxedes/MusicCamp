package com.example.musiccamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/")
@Controller
public class TestController {

    @GetMapping
    public String getLandingPage(){
        return"landingPage";
    }
}
