package com.ohma.todocamunda.dao;

import com.ohma.todocamunda.entity.Todo;
import com.ohma.todocamunda.vo.TodoVO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TodoDaoImpl extends TodoDaoBase {

    @Override
    public TodoVO toDto(Todo source, TodoVO target) {
        target = super.toDto(source, target);
        return target;
    }

    @Override
    public Todo toEntity(TodoVO source, Todo target) {
        target = super.toEntity(source, target);
        return target;
    }
}
