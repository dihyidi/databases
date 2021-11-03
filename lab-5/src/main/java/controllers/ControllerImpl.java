package controllers;

import dao.GenericDao;

import java.util.List;
import java.util.Scanner;

public abstract class ControllerImpl<T> implements Controller<T> {
    protected GenericDao<T> dao;
    protected final static Scanner input = new Scanner(System.in);

    protected ControllerImpl(GenericDao<T> dao){
        this.dao = dao;
    }

    @Override
    public List<T> getEntities() {
        return dao.getEntities();
    }

    @Override
    public T getEntityById(int id) {
        return dao.getEntityById(id);
    }

    @Override
    public boolean addEntity() { return false; }
    @Override
    public boolean addEntity(T entity) {
        return dao.addEntity(entity);
    }

    @Override
    public boolean updateEntity(int id) { return false; }

    @Override
    public boolean updateEntity(int id, T entity) {
        return dao.updateEntity(id, entity);
    }

    @Override
    public boolean deleteEntity(int id) {
        return dao.deleteEntity(id);
    }

    protected T inputEntity() { return null; }
}
