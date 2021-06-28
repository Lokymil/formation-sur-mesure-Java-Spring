package com.zenika.formation.apec.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column
    private boolean done;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getDone() {
        return done;
    }

    @Override
    public String toString() {
        return String.format("{\"id\":%d,\"title\":\"%s\",\"done\":%b}", id, title, done);
    }
}
