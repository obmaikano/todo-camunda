package com.ohma.todocamunda.dao;

import com.ohma.todocamunda.entity.Todo;
import com.ohma.todocamunda.repository.TodoRepository;
import com.ohma.todocamunda.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class TodoDaoBase extends AbstractGenericDao<Todo, TodoVO> implements TodoDao {

    @Autowired
    private TodoRepository repository;
    /**
     * @return
     */
    @Override
    public Todo createNewEntityInstance() {
        return new Todo();
    }

    /**
     * @return
     */
    @Override
    public TodoVO createNewDtoInstance() {
        return new TodoVO();
    }

    /**
     * @param source
     * @param target
     * @return
     */
    @Override
    public Todo toEntity(TodoVO source, Todo target) {
        target.setStartDateTime(source.getStartDateTime());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        return target;
    }

    /**
     * @param source
     * @param target
     * @return
     */
    @Override
    public TodoVO toDto(Todo source, TodoVO target) {
        target.setId(source.getId());
        target.setStartDateTime(source.getStartDateTime());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setCreateDateTime(source.getCreateDateTime());
        return target;
    }

    /**
     * @param dto
     * @return
     */
    @Override
    protected Todo loadEntityFromDto(TodoVO dto) {
        Todo entity = null;
        if(dto.getId() != null) {
            Optional<Todo> result = repository.findById(dto.getId());
            if(result.isPresent()) {
                return result.get();
            }
        }
        entity = createNewEntityInstance();
        toEntity(dto, entity);
        return entity;
    }
}
