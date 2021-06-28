package com.zenika.formation.apec.model;

public class TodoRequest {
    public String title;

    public Todo toTodo() {
        return new Todo(title);
    }
}
