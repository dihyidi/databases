package controllers;

import dao.PatientDaoImpl;
import models.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientController extends ControllerImpl<Patient> {

    public PatientController() {
        super(new PatientDaoImpl());
    }

    @Override
    public boolean addEntity() {
        Patient patient = inputEntity();
        return super.addEntity(patient);
    }

    @Override
    public boolean updateEntity(int id) {
        Patient patient = inputEntity();
        return super.updateEntity(id, patient);
    }

    @Override
    protected Patient inputEntity() {
        System.out.println("Please input name:");
        var name = input.nextLine();
        System.out.println("Please input surname:");
        var surname = input.nextLine();
        System.out.println("Please input birthday:");
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("dd/MM/yyyy").parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Please input address:");
        var address = input.nextLine();
        return new Patient(name, surname, birthday, address);
    }
}
