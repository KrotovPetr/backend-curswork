package com.cursproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "localhost:3000/login";
    }

    @GetMapping("/home")
    public String getSuccessPage() {
        return "localhost:3000/home";
    }
}