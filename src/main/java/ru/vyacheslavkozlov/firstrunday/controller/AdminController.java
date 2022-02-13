package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/runday/admin")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasAuthority('account:write')")
    public String helloAdmin(){
        return "admin";
    }
}
