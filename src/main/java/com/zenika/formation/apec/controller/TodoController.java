package com.zenika.formation.apec.controller;

import com.zenika.formation.apec.model.Todo;
import com.zenika.formation.apec.model.TodoRequest;
import com.zenika.formation.apec.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
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
    public Todo createOne(@RequestBody TodoRequest todo, HttpServletResponse response) {
        Todo createdTodo = todoService.createOneTodo(todo.title);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return createdTodo;
    }

    @GetMapping("/todos/{id}")
    public Todo getOne(@PathVariable("id") long id) {
        Optional<Todo> todo = todoService.getOneTodo(id);
        if (!todo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        } else {
            return todo.get();
        }
    }

    @PutMapping("/todos/{id}")
    public Todo updateOne(@PathVariable("id") long id, @RequestBody TodoRequest todoRequest) {
        Optional<Todo> todo = todoService.getOneTodo(id);
        if (!todo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }

        Todo changedTodo = todo.map(t -> {
            t.title = todoRequest.title;
            return t;
        }).get();

        return todoService.updateOneTodo(changedTodo);
    }

    @PostMapping("/todos/{id}/done")
    public void doneOne(@PathVariable("id") long id, HttpServletResponse response) {
        Optional<Todo> todo = todoService.getOneTodo(id);
        if (!todo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }

        Todo changedTodo = todo.map(t -> {
            t.done = true;
            return t;
        }).get();

        todoService.updateOneTodo(changedTodo);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @PostMapping("/todos/{id}/undo")
    public void undoOne(@PathVariable("id") long id, HttpServletResponse response) {
        Optional<Todo> todo = todoService.getOneTodo(id);
        if (!todo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }

        Todo changedTodo = todo.map(t -> {
            t.done = false;
            return t;
        }).get();

        todoService.updateOneTodo(changedTodo);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
