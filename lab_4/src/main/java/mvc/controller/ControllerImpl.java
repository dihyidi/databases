package mvc.controller;

import mvc.model.managers.ManagerImpl;

import java.util.List;

public class ControllerImpl<T> implements Controller<T>{
    protected ManagerImpl<T> manager;

    protected ControllerImpl(ManagerImpl<T> manager){
        this.manager = manager;
    }
    @Override
    public List<T> getBeans() {
        return manager.getBeans();
    }

    @Override
    public T getBeanById(int id) {
        return manager.getBeanById(id);
    }

    @Override
    public boolean addBean(T bean) {
        return manager.addBean(bean);
    }

    @Override
    public boolean updateBean(int id, T bean) {
        return manager.updateBean(id, bean);
    }

    @Override
    public boolean deleteBean(int id) {
        return manager.deleteBean(id);
    }

}
