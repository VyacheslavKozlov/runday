package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vyacheslavkozlov.firstrunday.service.AccountService;

@AllArgsConstructor
@Controller
@RequestMapping("/runday/registration")
public class RegistrationController {

    private final AccountService accountService;

    @GetMapping
    public String getRegistrationPage(){
        return "registration";
    }

//    @PostMapping
//    public Account createAccount(@RequestBody Account account){
//        accountService.save(account);
//        return account;
//    }
}
