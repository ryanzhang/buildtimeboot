package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @Autowired
    Person person;

    @GetMapping("api/v1/hello")
    public String hello(){
        return "hello" + person.getName();
    }
}
