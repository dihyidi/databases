package mvc.controller;

import mvc.model.beans.Specialization;
import mvc.model.managers.SpecializationManager;


public class SpecializationController extends ControllerImpl<Specialization> {

    public SpecializationController() {
        super(new SpecializationManager());
    }
}
