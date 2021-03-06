package com.example.springsecuritybasicauthauthorities.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorityDemoController {

    @GetMapping("/post/method")
    public String post(){
        return "This is secure POST method";
    }

    @GetMapping("/get/method")
    public String get(){
        return "This is secure GET method";
    }

    @GetMapping("/delete/method")
    public String delete(){
        return "This is secure DELETE method";
    }
}
