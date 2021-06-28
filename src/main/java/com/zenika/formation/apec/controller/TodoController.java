package com.zenika.formation.apec.controller;

import com.zenika.formation.apec.model.Todo;
import com.zenika.formation.apec.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    public Todo getOne(@PathVariable("id") long id) {
        Optional<Todo> todo = todoService.getOneTodo(id);
        if (!todo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo with not found");
        } else {
            return todo.get();
        }
    }

    @PutMapping("/todos/{id]")
    public String updateOne(@PathVariable("id") long id) {
        return "Not implemented yet for id : " + id;
    }
}
