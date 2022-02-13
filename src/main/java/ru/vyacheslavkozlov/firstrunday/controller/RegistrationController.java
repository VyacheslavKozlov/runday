package ru.vyacheslavkozlov.firstrunday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vyacheslavkozlov.firstrunday.service.AccountService;

@RestController
public class RegistrationController {
    public final AccountService accountService;

    public RegistrationController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String getStartPage(Model model){
        return "Hello!";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

}
