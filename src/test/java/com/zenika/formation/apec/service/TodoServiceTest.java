package com.zenika.formation.apec.service;

import com.zenika.formation.apec.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoServiceTest {
    @Autowired
    TodoService todoService;

    @Test
    void givenValidTodo_whenValidateTodo_thenEmptyErrorList() {
        Todo validTodo = new Todo("Valid title");
        List<String> errors = todoService.validateTodo(validTodo);

        assertEquals(errors.size(), 0);
    }

    @Test
    void givenTodoNoTitle_whenValidateTodo_thenNoTitleErrorInList() {
        Todo validTodo = new Todo("");
        List<String> errors = todoService.validateTodo(validTodo);

        assertArrayEquals(
                errors.toArray(),
                Arrays.asList("Title is required").toArray());
    }

    @Test
    void givenTodoNullTitle_whenValidateTodo_thenNoTitleErrorInList() {
        Todo validTodo = new Todo("");
        List<String> errors = todoService.validateTodo(validTodo);

        assertArrayEquals(
                errors.toArray(),
                Arrays.asList("Title is required").toArray());
    }

    @Test
    void givenTodoTooLongTitle_whenValidateTodo_thenTooLongTitleErrorInList() {
        Todo validTodo = new Todo("This is a title with 100+ characters ! This is a title with 100+ characters ! This is a title with 100+ characters ! This is a title with 100+ characters !");
        List<String> errors = todoService.validateTodo(validTodo);

        assertArrayEquals(
                errors.toArray(),
                Arrays.asList("Title must me bellow 100 characters").toArray());
    }
}