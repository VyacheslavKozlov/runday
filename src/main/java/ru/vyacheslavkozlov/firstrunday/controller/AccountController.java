package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vyacheslavkozlov.firstrunday.entity.*;
import ru.vyacheslavkozlov.firstrunday.service.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
@RequestMapping("/runday/runner")
public class AccountController {

    private final AccountDetailsServiceImpl accountDetailsService;
    private final ProducerServiceImpl producerService;
    private final ShoeModelServiceImpl shoeModelService;
    private final SneakersServiceImpl sneakersService;

    @GetMapping
    public String getPageRunner(HttpServletRequest request, Model model){

        Account account = accountDetailsService.findByEmail(request.getRemoteUser());

        List<Sneakers> allSneakersByAccountId = sneakersService.findAllByAccountId(account.getId());
        List<Workout> workouts = allSneakersByAccountId.stream().flatMap(sneakers -> sneakers.getWorkouts().stream()).collect(Collectors.toList());
        model.addAttribute("account", account);
        model.addAttribute("sneakers", allSneakersByAccountId);
        model.addAttribute("workout", workouts);

        List<Producer> allProducers = producerService.findAll();
        List<ShoeModel> allShoeModels = shoeModelService.findAll();

        model.addAttribute("producers", allProducers);
        model.addAttribute("shoeModels", allShoeModels);

//        allSneakersByAccountId.stream().forEach(sneakers -> sneakers.getWorkouts().stream().forEach(System.out::println));
//        allSneakersByAccountId.stream().flatMap(sneakers -> workoutService.findAllBySneakersId(sneakers.getId()).stream())
//                .collect(Collectors.toList());
        return "runner";
    }
}
