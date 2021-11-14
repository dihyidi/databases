package controllers;

import dao.DoctorDaoImpl;
import models.Doctor;

public class DoctorController extends ControllerImpl<Doctor> {
    private final SpecializationController specializationController;

    public DoctorController() {
        super(new DoctorDaoImpl());
        specializationController = new SpecializationController();
    }

    @Override
    public boolean addEntity(){
        Doctor doctor = inputEntity();
        return super.addEntity(doctor);
    }

    @Override
    public boolean updateEntity(int id) {
        Doctor doctor = inputEntity();
        doctor.setId(id);
        return super.updateEntity(id, doctor);
    }

    @Override
    protected Doctor inputEntity() {
        System.out.println("Please input name:");
        var name = input.nextLine();
        System.out.println("Please input experience:");
        var exp = Integer.parseInt(input.nextLine());
        System.out.println("Please input specialization id:");
        var specId = Integer.parseInt(input.nextLine());
        var spec =  this.specializationController.getEntityById(specId);
        return new Doctor(name, exp, spec);
    }
}
