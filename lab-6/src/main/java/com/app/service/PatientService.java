package com.app.service;

import com.app.domain.Patient;
import com.app.dto.PatientDto;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.app.repo.PatientRepo;

@AllArgsConstructor
@Service
public class PatientService extends BaseService<Patient, Integer, PatientDto> {
    public PatientRepo repo;
    @Override
    protected JpaRepository<Patient, Integer> getRepository() { return repo; }

    @Override
    protected Patient convertDtoToEntity(PatientDto patientDto) {
        return new Patient(patientDto.getName(), patientDto.getSurname(), patientDto.getAddress(), patientDto.getBirthday());
    }
}
