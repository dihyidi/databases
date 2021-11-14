package dao;

import models.Patient;

public class PatientDaoImpl extends GenericDaoImpl<Patient> {
    public PatientDaoImpl() {
        super(Patient.class);
    }
}
