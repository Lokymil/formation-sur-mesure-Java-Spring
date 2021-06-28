package com.zenika.formation.apec.controller;

import com.zenika.formation.apec.model.Todo;
import com.zenika.formation.apec.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> list() {
        return todoService.getAllTodos();
    }
}
