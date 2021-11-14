package com.app.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<T, TId> {
    protected abstract JpaRepository<T, TId> getRepository();

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T getById(TId id) {
        return getRepository().getOne(id);
    }

    public T create(T object) {
        return getRepository().save(object);
    }

    public T update(TId id, T object) {
        if (getRepository().findById(id).isPresent()) {
            return getRepository().save(object);
        } else {
            return null;
        }
    }

    public void deleteById(TId id) {
        if (getRepository().findById(id).isPresent()) {
            getRepository().deleteById(id);
        }
    }
}
