package controllers;

import java.util.List;

public interface Controller<T> {
    List<T> getEntities();
    T getEntityById(int id);
    boolean addEntity();
    boolean addEntity(T entity);
    boolean updateEntity(int id);
    boolean updateEntity(int id, T entity);
    boolean deleteEntity(int id);
}
