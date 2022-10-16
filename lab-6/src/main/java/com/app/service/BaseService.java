package com.app.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, TId, TDto> {
    protected abstract JpaRepository<T, TId> getRepository();

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T getById(TId id) {
        Optional<T> entity = getRepository().findById(id);
        return entity.orElse(null);
    }

    public T create(TDto dto) {
        T entity = this.convertDtoToEntity(dto);
        return getRepository().save(entity);
    }

    public T update(TId id, TDto dto) {
        if (getRepository().findById(id).isPresent()) {
            T entity = this.convertDtoToEntity(dto);
            return getRepository().save(entity);
        } else {
            return null;
        }
    }

    public void deleteById(TId id) {
        getRepository().deleteById(id);
    }

    protected abstract T convertDtoToEntity(TDto dto);
}
