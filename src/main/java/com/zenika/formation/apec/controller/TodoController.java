package com.zenika.formation.apec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @GetMapping("/todo")
    public String list() {
        return "Init API";
    }
}
