package dao;

import java.util.List;

public interface GenericDao<T> {
    List<T> getEntities();
    T getEntityById(int id);
    boolean addEntity(T entity);
    boolean updateEntity(int id, T entity);
    boolean deleteEntity(int id);
}
