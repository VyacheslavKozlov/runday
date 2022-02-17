package ru.vyacheslavkozlov.firstrunday.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/runday/auth")
public class LoginController {

    @GetMapping("/login")
    public String getSingInPage(){
        return "login";
    }

//    @PostMapping("/login")
//    public String getAccountPage(@RequestParam("username") String username){
//        System.out.println("loginController username =" + username);
//        return "redirect:/runday/runner";
//    }

    @GetMapping("/success")
    @PreAuthorize("hasAnyAuthority('account:read', 'account:write')")
    public String getSuccessPage(){
        return "success";
    }

    @GetMapping("/logout")
    @PreAuthorize("hasAnyAuthority('account:read', 'account:write')")
    public String getLogoutPage(){
        return "logout";
    }
}