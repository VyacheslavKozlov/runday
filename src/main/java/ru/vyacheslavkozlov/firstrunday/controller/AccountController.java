package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/runday/runner")
public class AccountController {

    @GetMapping
    public String getPageRunner(){
        return "runner";
    }
}
