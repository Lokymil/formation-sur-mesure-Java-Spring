package com.zenika.formation.apec.repository;

import com.zenika.formation.apec.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
