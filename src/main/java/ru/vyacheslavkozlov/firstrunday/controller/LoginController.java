package ru.vyacheslavkozlov.firstrunday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/runday/auth")
public class LoginController {

    @GetMapping("/login")
    public String getSingInPage(){
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage(){
        return "success";
    }

    @GetMapping("/logout")
    public String getLogoutPage(){
        return "logout";
    }
}