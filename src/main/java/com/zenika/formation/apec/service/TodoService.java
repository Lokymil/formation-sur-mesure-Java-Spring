package com.zenika.formation.apec.service;

import com.zenika.formation.apec.model.Todo;
import com.zenika.formation.apec.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    public Optional<Todo> getOneTodo(long id) {
        return todoRepository.findById(id);
    }

    public Todo createOneTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateOneTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<String> validateTodo(Todo todo) {
        List<String> errors = new ArrayList<>();
        if (todo.title == null || todo.title.length() == 0) {
            errors.add("Title is required");
        }

        if (todo.title != null && todo.title.length() > 100) {
            errors.add("Title must me bellow 100 characters");
        }

        return errors;
    }
}
