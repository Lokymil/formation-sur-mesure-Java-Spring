package com.zenika.formation.apec.controller;

import com.zenika.formation.apec.model.Todo;
import com.zenika.formation.apec.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> listAll() {
        return todoService.getAllTodos();
    }

    @PostMapping("/todos")
    public String createOne() {
        return "Not implemented yet";
    }

    @GetMapping("/todos/{id}")
    public String getOne(@PathVariable("id") int id) {
        return "Not implemented yet for id : " + id;
    }

    @PutMapping("/todos/{id]")
    public String updateOne(@PathVariable("id") int id) {
        return "Not implemented yet for id : " + id;
    }
}
