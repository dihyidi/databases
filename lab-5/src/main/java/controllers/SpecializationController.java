package controllers;

import dao.SpecializationDaoImpl;
import models.Specialization;

public class SpecializationController extends ControllerImpl<Specialization> {

    public SpecializationController() {
        super(new SpecializationDaoImpl());
    }

    @Override
    public boolean addEntity(){
        Specialization specialization = inputEntity();
        return super.addEntity(specialization);
    }

    @Override
    public boolean updateEntity(int id) {
        Specialization specialization = inputEntity();
        return super.updateEntity(id, specialization);
    }

    @Override
    protected Specialization inputEntity() {
        System.out.println("Please input name:");
        var name = input.nextLine();
        return new Specialization(name);
    }
}
