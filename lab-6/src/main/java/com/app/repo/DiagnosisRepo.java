package com.app.repo;

import com.app.domain.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepo extends JpaRepository<Diagnosis, Integer> {
}
