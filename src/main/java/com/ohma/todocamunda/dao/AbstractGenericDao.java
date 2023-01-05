package com.ohma.todocamunda.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractGenericDao<E, D> implements GenericDao<E, D> {

    private Class<E> entityClass;

    private Class<D> dtoClass;

    public abstract E createNewEntityInstance();

    public abstract D createNewDtoInstance();

    public abstract E toEntity(D source, E target);

    public abstract D toDto(E source, D target);

    protected abstract E loadEntityFromDto(D dto);
    @Override
    public D toDto(E entity) {
        if(entity == null) {
            return null;
        }
        D dto = createNewDtoInstance();
        return toDto(entity, dto);
    }

    /**
     * Maps the given BaseEntity Value Object to the corresponding entity of type E
     */
    @Override
    public E toEntity(D dto) {
        if(dto == null) {
            return null;
        }
        E entity = loadEntityFromDto(dto);
        return toEntity(dto, entity);
    }

    /**
     *  (non-Javadoc)
     */
    @Override
    public List<D> toDtoCollection(Collection<E> entities) {
        List<D> dtos = new ArrayList<>();
        if(entities != null) {
            for(E entity : entities) {
                dtos.add(toDto(entity));
            }
        }

        return dtos;
    }
    /**
     *  (non-Javadoc)
     */
    @Override
    public List<E> toEntityCollection(Collection<D> dtos) {
        List<E> entities = new ArrayList<>();
        for(D dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}
