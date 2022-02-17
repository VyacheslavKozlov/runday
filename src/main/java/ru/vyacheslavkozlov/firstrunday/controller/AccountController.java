package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vyacheslavkozlov.firstrunday.config.WebSecurityConfig;
import ru.vyacheslavkozlov.firstrunday.config.security.SecurityAccount;
import ru.vyacheslavkozlov.firstrunday.entity.Account;
import ru.vyacheslavkozlov.firstrunday.repository.AccountRepository;
import ru.vyacheslavkozlov.firstrunday.service.impl.AccountDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Controller
@RequestMapping("/runday/runner")
public class AccountController {

    private final AccountDetailsServiceImpl accountDetailsService;

    @GetMapping
    public String getPageRunner(HttpServletRequest request, Model model){

        System.out.println(request.getRemoteUser());
        Account account = accountDetailsService.findByEmail(request.getRemoteUser());
        System.out.println(account);

        return "runner";
    }
}
