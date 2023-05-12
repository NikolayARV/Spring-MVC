package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FirstController {
    private int counter;
    @GetMapping
    public String showHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/counter")
    public String showCounter() {
        return "Количество запросов: " + ++counter;
    }
}
