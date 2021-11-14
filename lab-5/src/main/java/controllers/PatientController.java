package controllers;

import dao.PatientDaoImpl;
import models.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientController extends ControllerImpl<Patient> {
private final DiagnosisController diagnosisController;

    public PatientController() {
        super(new PatientDaoImpl());
        this.diagnosisController = new DiagnosisController();
    }

    @Override
    public boolean addEntity() {
        Patient patient = inputEntity();
        return super.addEntity(patient);
    }

    @Override
    public boolean updateEntity(int id) {
        Patient patient = inputEntity();
        patient.setId(id);
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

    public boolean addDiagnosis() {
        var success = false;

        System.out.println("Please input patient id:");
        var patientId = Integer.parseInt(input.nextLine());
        var patient = this.getEntityById(patientId);
        System.out.println("Please input diagnosis id:");
        var diagnosisId = Integer.parseInt(input.nextLine());
        var diagnosis = this.diagnosisController.getEntityById(diagnosisId);

        try {
            var prev = patient.getDiagnoses();
            prev.add(diagnosis);
            patient.setDiagnoses(prev);
            this.updateEntity(patientId, patient);
            success = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return success;
    }
}
