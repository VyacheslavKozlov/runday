package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vyacheslavkozlov.firstrunday.entity.Account;
import ru.vyacheslavkozlov.firstrunday.service.impl.AccountDetailsServiceImpl;

@AllArgsConstructor
@Controller
@RequestMapping("/runday/registration")
public class RegistrationController {

    private final AccountDetailsServiceImpl accountDetailsService;

    @GetMapping
    public String getRegistrationPage(Model model){
        model.addAttribute("account", new Account());
        return "registration";
    }

    @PostMapping
    public String createAccount(@ModelAttribute Account account){
        accountDetailsService.save(account);
        return "login";
    }
}
