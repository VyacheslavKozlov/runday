package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vyacheslavkozlov.firstrunday.entity.Account;
import ru.vyacheslavkozlov.firstrunday.entity.Producer;
import ru.vyacheslavkozlov.firstrunday.entity.Sneakers;
import ru.vyacheslavkozlov.firstrunday.service.impl.ProducerServiceImpl;
import ru.vyacheslavkozlov.firstrunday.service.impl.SneakersServiceImpl;
import ru.vyacheslavkozlov.firstrunday.service.impl.AccountDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/runday/runner")
public class AccountController {

    private final AccountDetailsServiceImpl accountDetailsService;
    private final ProducerServiceImpl producerService;
    private final SneakersServiceImpl sneakersService;

    @GetMapping
    public String getPageRunner(HttpServletRequest request, Model model){

        System.out.println(request.getRemoteUser());
        Account account = accountDetailsService.findByEmail(request.getRemoteUser());
        System.out.println(account);
        List<Sneakers> allSneakersByAccountId = sneakersService.findAllByAccountId(account.getId());
        System.out.println(allSneakersByAccountId);
        List<Producer> allProducers = producerService.findAll();



        return "runner";
    }
}
