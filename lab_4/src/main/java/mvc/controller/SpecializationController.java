package mvc.controller;

import mvc.model.beans.Specialization;
import mvc.model.managers.SpecializationManager;

import java.util.List;

public class SpecializationController implements Controller<Specialization> {

    private final SpecializationManager manager;

    public SpecializationController(){
        manager = new SpecializationManager();
    }

    @Override
    public List<Specialization> getBeans() {
        return manager.getBeans();
    }

    @Override
    public Specialization getBeanById(int id) {
        return manager.getBeanById(id);
    }

    @Override
    public boolean addBean(Specialization bean) {
        return manager.addBean(bean);
    }

    @Override
    public boolean updateBean(int id, Specialization bean) {
        return manager.updateBean(id, bean);
    }

    @Override
    public boolean deleteBean(int id) {
        return manager.deleteBean(id);
    }
}
