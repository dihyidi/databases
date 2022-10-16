package com.app.mapper;

import com.app.domain.Diagnosis;
import com.app.domain.Patient;
import com.app.dto.PatientDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PatientMapper implements BaseMapper<Patient, PatientDto> {
    @Override
    public PatientDto mapEntityToDto(Patient patient) {
        return new PatientDto(patient.getId(), patient.getName(), patient.getSurname(), patient.getBirthday(),
                patient.getAddress(), patient.getDiagnoses().stream().map(Diagnosis::getId).collect(Collectors.toSet()));
    }
}
