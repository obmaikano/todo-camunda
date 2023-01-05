package com.ohma.todocamunda.repository;

import com.ohma.todocamunda.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByTitleContainingIgnoreCase(String title);

    List<Todo> findByDescriptionContainingIgnoreCase(String description);
}
