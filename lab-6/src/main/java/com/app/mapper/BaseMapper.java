package com.app.mapper;

public interface BaseMapper<TEntity, TDto> {
    TDto mapEntityToDto(TEntity entity);
}
