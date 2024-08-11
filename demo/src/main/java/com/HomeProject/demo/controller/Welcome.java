package com.HomeProject.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @RequestMapping("/greet")
    public String greet(){
        return "Greetings!";
    }

}
