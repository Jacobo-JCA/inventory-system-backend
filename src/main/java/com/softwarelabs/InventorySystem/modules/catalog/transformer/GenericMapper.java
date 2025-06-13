package com.softwarelabs.InventorySystem.modules.catalog.transformer;

import org.modelmapper.ModelMapper;

public class GenericMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public static <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    public static <E, D> E convertToEntity(D dto, Class<E> entityClass) {
        return mapper.map(dto, entityClass);
    }
}
