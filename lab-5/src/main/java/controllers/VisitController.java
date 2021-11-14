package controllers;

import dao.VisitDaoImpl;
import models.Visit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitController extends ControllerImpl<Visit> {
    private final DoctorController doctorController;
    private final PatientController patientController;

    public VisitController() {
        super(new VisitDaoImpl());
        doctorController = new DoctorController();
        patientController = new PatientController();
    }

    @Override
    public boolean addEntity(){
        Visit visit = inputEntity();
        return super.addEntity(visit);
    }

    @Override
    public boolean updateEntity(int id) {
        Visit visit = inputEntity();
        visit.setId(id);
        return super.updateEntity(id, visit);
    }

    @Override
    protected Visit inputEntity() {
        System.out.println("Please input date:");
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Please input price:");
        var price = Integer.parseInt(input.nextLine());
        System.out.println("Please input doctor id:");
        var doctorId = Integer.parseInt(input.nextLine());
        var doctor = doctorController.getEntityById(doctorId);
        System.out.println("Please input patient id:");
        var patientId = Integer.parseInt(input.nextLine());
        var patient = patientController.getEntityById(patientId);
        return new Visit(date,price,patient,doctor);
    }
}
