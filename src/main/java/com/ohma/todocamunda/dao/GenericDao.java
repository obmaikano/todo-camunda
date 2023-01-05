package com.ohma.todocamunda.dao;

import java.util.Collection;

public interface GenericDao<E, D>{
    /**
     * Converts the Entity to Data Transfer Object
     * @param entity
     * @return
     */
    //@InheritConfiguration
    D toDto(E entity);

    /**
     * Converts the Data Transfer Object to Entity
     * @param dto
     * @return
     */
    //@InheritConfiguration(name = "toEntity")
    E toEntity(D dto);

    /**
     *
     * @param dto
     * @param entity
     * @return
     */
    //E toEntity(D dto, @MappingTarget E entity);

    /**
     * Converts a Collection of Entities to a Collection of Dtos
     * @param entities
     * @return
     */
    Collection<D> toDtoCollection(Collection<E> entities);

    /**
     * Converts the Collection of Dtos to Entities
     * @param dtos
     * @return
     */
    Collection<E> toEntityCollection(Collection<D> dtos);
}
