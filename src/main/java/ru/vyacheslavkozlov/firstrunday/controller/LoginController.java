package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/runday/auth")
public class LoginController {

    @GetMapping("/login")
    public String getSingInPage(){
        return "login";
    }

//    @PostMapping("/login")
//    public String goSuccessPage(){
//        return "success";
//    }

    @GetMapping("/success")
    public String getSuccessPage(){
        return "success";
    }
}
