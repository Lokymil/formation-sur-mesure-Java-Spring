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
import java.util.stream.Collectors;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> listAll() {
        return todoService.getAllTodos();
    }

    @PostMapping("/todos")
    public Todo createOne(@RequestBody TodoRequest todoRequest, HttpServletResponse response) {
        Todo todoToCreate = todoRequest.toTodo();
        validateTodo(todoToCreate);
        Todo createdTodo = todoService.createOneTodo(todoToCreate);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return createdTodo;
    }

    @GetMapping("/todos/{id}")
    public Todo getOne(@PathVariable("id") long id) {
        return getTodo(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateOne(@PathVariable("id") long id, @RequestBody TodoRequest todoRequest) {
        Todo todoToUpdate = getTodo(id);
        todoToUpdate.title = todoRequest.title;
        validateTodo(todoToUpdate);

        return todoService.updateOneTodo(todoToUpdate);
    }

    @PostMapping("/todos/{id}/done")
    public void doneOne(@PathVariable("id") long id, HttpServletResponse response) {
        Todo todoToUpdate = getTodo(id);
        todoToUpdate.done = true;

        todoService.updateOneTodo(todoToUpdate);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @PostMapping("/todos/{id}/undo")
    public void undoOne(@PathVariable("id") long id, HttpServletResponse response) {
        Todo todoToUpdate = getTodo(id);
        todoToUpdate.done = false;

        todoService.updateOneTodo(todoToUpdate);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteOne(@PathVariable("id") long id, HttpServletResponse response) {
        Todo todoToUpdate = getTodo(id);

        todoService.deleteOneTodo(todoToUpdate);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    private Todo getTodo(long id) {
        Optional<Todo> todo = todoService.getOneTodo(id);
        if (!todo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        } else {
            return todo.get();
        }
    }

    private void validateTodo(Todo todo) {
        List<String> errors = todoService.validateTodo(todo);
        if (errors.size() > 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    errors.stream().collect(Collectors.joining(",", "[", "]")));
        }
    }
}
