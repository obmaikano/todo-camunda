package com.ohma.todocamunda.service;

import com.ohma.todocamunda.dao.TodoDao;
import com.ohma.todocamunda.entity.Todo;
import com.ohma.todocamunda.repository.TodoRepository;
import com.ohma.todocamunda.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoDao todoDao;

    public TodoVO createTodo(TodoVO todoVO) {
        Todo todo = todoDao.toEntity(todoVO);
        todo = todoRepository.save(todo);
        return todoDao.toDto(todo);
    }

    public List<TodoVO> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todoDao::toDto).collect(Collectors.toList());
    }
}
