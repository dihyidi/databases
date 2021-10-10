package mvc.controller;

import mvc.model.beans.Doctor;
import mvc.model.managers.DoctorManager;

public class DoctorController extends ControllerImpl<Doctor> {

    public DoctorController() {
        super(new DoctorManager());
    }
}
