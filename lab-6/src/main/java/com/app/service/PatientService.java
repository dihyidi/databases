package com.app.service;

import com.app.domain.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.app.repo.PatientRepo;

@AllArgsConstructor
@Service
public class PatientService extends BaseService<Patient, Integer> {
    public PatientRepo repo;
    @Override
    protected JpaRepository<Patient, Integer> getRepository() { return repo; }
}
