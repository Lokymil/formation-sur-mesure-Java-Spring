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

    public Todo createOneTodo(String title) {
        return todoRepository.save(new Todo(title));
    }
}
