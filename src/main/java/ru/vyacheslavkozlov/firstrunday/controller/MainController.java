package ru.vyacheslavkozlov.firstrunday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping(value = {"/","/runday"})
    public String goHello(){
        return "hello";
    }


}
