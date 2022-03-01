package ru.vyacheslavkozlov.firstrunday.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.vyacheslavkozlov.firstrunday.entity.*;
import ru.vyacheslavkozlov.firstrunday.service.ProducerService;
import ru.vyacheslavkozlov.firstrunday.service.ShoeModelService;
import ru.vyacheslavkozlov.firstrunday.service.impl.AccountDetailsServiceImpl;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/runday/admin")
public class AdminController {

    private final AccountDetailsServiceImpl accountDetailsService;
    private final ProducerService producerService;
    private final ShoeModelService shoeModelService;

    @GetMapping
    public ModelAndView getAdminPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping("/runner")
    public List<Account> getAllRunners(){
        return accountDetailsService.findAll();
    }

    @PostMapping("/runner")
    public void addNewRunner(@RequestBody Account account){
        accountDetailsService.save(account);
    }

    @PatchMapping("/runneredit")
    public void editRunner(@RequestBody Account account){
        System.out.println("PatchMapping runner " + account);
        accountDetailsService.update(account);
    }

    @GetMapping("/producer")
    public List<Producer> getAllProducers(){
        return producerService.findAll();
    }

    @PatchMapping("/produceredit")
    public void updateProducer(@RequestBody Producer producer){
        System.out.println("PatchMapping producer " + producer);
        producerService.update(producer);
    }

    @PostMapping("/produceradd")
    public void addProducer(@RequestBody String producerName){
        System.out.println("addProducer " + producerName);
        producerService.add(producerName);
    }

    @DeleteMapping("/producer/{id}")
    public void deleteProducer(@PathVariable("id") int producerId){
        producerService.delete(producerId);
    }

    @GetMapping("/shoemodels")
    public List<ShoeModel> getAllShoeModels(){
        return shoeModelService.findAll();
    }
}
