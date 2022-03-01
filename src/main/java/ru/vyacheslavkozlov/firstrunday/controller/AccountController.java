package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.vyacheslavkozlov.firstrunday.entity.*;
import ru.vyacheslavkozlov.firstrunday.repository.SneakersRepository;
import ru.vyacheslavkozlov.firstrunday.service.SneakersService;
import ru.vyacheslavkozlov.firstrunday.service.WorkoutService;
import ru.vyacheslavkozlov.firstrunday.service.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/runday/runner")
public class AccountController {

    private final AccountDetailsServiceImpl accountDetailsService;
    private final ProducerServiceImpl producerService;
    private final ShoeModelServiceImpl shoeModelService;
    private final SneakersService sneakersService;
    private final WorkoutService workoutService;

    @GetMapping
    public ModelAndView getPageRunner(HttpServletRequest request){
        Account account = accountDetailsService.findByEmail(request.getRemoteUser());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("runner");
        modelAndView.addObject("account", account);
        return modelAndView;
    }

    @GetMapping("/sneakers")
    public List<Sneakers> getSneakersByAccountId(HttpServletRequest request){

        Account account = accountDetailsService.findByEmail(request.getRemoteUser());

        List<Sneakers> allSneakersByAccountId = sneakersService.findAllByAccountId(account.getId());
//        List<Workout> workouts = allSneakersByAccountId.stream().flatMap(sneakers -> sneakers.getWorkouts().stream()).collect(Collectors.toList());
//        model.addAttribute("account", account);
//        model.addAttribute("sneakers", allSneakersByAccountId);
//        model.addAttribute("workout", workouts);
//
//        List<Producer> allProducers = producerService.findAll();
//        List<ShoeModel> allShoeModels = shoeModelService.findAll();
//        model.addAttribute("producers", allProducers);
//        model.addAttribute("shoeModels", allShoeModels);

//        allSneakersByAccountId.stream().forEach(sneakers -> sneakers.getWorkouts().stream().forEach(System.out::println));
//        allSneakersByAccountId.stream().flatMap(sneakers -> workoutService.findAllBySneakersId(sneakers.getId()).stream())
//                .collect(Collectors.toList());
        return allSneakersByAccountId;
    }

    @GetMapping("/allsneakers")
    public List<Sneakers> getAllSneakers(){
        return sneakersService.findAll();
    }

    @GetMapping("/workout")
    public List<Workout> getAllWorkoutByAccountId(HttpServletRequest request){
        Account account = accountDetailsService.findByEmail(request.getRemoteUser());
        List<Sneakers> allSneakersByAccountId = sneakersService.findAllByAccountId(account.getId());
        List<Workout> allWorkoutBySneakersId = allSneakersByAccountId.stream().flatMap(sneakers -> sneakers.getWorkouts().stream()).collect(Collectors.toList());
        return allWorkoutBySneakersId;
    }

    @PatchMapping("/sneakers/update")
    public void updateSneakers(@RequestBody Sneakers sneakers){
        System.out.println("updateSneakers " + sneakers);
        sneakersService.update(sneakers);
    }

}
