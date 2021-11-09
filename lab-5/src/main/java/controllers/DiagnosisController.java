package controllers;

import dao.DiagnosisDaoImpl;
import models.Diagnosis;

public class DiagnosisController extends ControllerImpl<Diagnosis> {

    public DiagnosisController() {
        super(new DiagnosisDaoImpl());
    }

    @Override
    public boolean addEntity(){
        Diagnosis diagnosis = inputEntity();
        return super.addEntity(diagnosis);
    }

    @Override
    public boolean updateEntity(int id) {
        Diagnosis diagnosis = inputEntity();
        diagnosis.setId(id);
        return super.updateEntity(id, diagnosis);
    }

    @Override
    protected Diagnosis inputEntity() {
        System.out.println("Please input name:");
        var name = input.nextLine();
        System.out.println("Please input protocol:");
        var protocol = input.nextLine();
        return new Diagnosis(name, protocol);
    }
}
