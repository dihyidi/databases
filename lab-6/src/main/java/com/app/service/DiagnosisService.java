package com.app.service;

import com.app.domain.Diagnosis;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.app.repo.DiagnosisRepo;

@AllArgsConstructor
@Service
public class DiagnosisService extends BaseService<Diagnosis, Integer> {
    public DiagnosisRepo repo;
    @Override
    protected JpaRepository<Diagnosis, Integer> getRepository() { return repo; }
}
