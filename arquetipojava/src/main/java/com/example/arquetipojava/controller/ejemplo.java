package com.example.arquetipojava.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ejemplo {
    @GetMapping("")
    public String hola(){
        return "Hola mundo";
    }
}
