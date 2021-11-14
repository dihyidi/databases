package com.app.mapper;

import com.app.domain.Patient;
import com.app.dto.PatientDto;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper implements BaseMapper<Patient, PatientDto> {
    @Override
    public PatientDto mapEntityToDto(Patient patient) {
        return new PatientDto(patient.getId(), patient.getName(), patient.getSurname(), patient.getBirthday(), patient.getAddress(), patient.getDiagnoses());
    }
}
