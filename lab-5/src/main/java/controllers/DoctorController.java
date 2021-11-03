package controllers;

import dao.DoctorDaoImpl;
import models.Doctor;

public class DoctorController extends ControllerImpl<Doctor> {

    public DoctorController() {
        super(new DoctorDaoImpl());
    }

    @Override
    public boolean addEntity(){
        Doctor doctor = inputEntity();
        return super.addEntity(doctor);
    }

    @Override
    public boolean updateEntity(int id) {
        Doctor doctor = inputEntity();
        return super.updateEntity(id, doctor);
    }

    @Override
    protected Doctor inputEntity() {
        System.out.println("Please input name:");
        var name = input.nextLine();
        System.out.println("Please input experience:");
        var exp = Integer.parseInt(input.nextLine());
        return new Doctor(name, exp);
    }
}
