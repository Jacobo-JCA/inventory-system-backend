package com.softwarelabs.InventorySystem.modules.catalog.common.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

public class GenericMapper {
    @Qualifier("catalog")
    private static final ModelMapper mapper = new ModelMapper();

    public static <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    public static <E, D> E convertToEntity(D dto, Class<E> entityClass) {
        return mapper.map(dto, entityClass);
    }
}
