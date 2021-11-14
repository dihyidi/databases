package com.app.service;

import com.app.domain.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.app.repo.DoctorRepo;

@AllArgsConstructor
@Service
public class DoctorService extends BaseService<Doctor, Integer> {
    public DoctorRepo repo;
    @Override
    protected JpaRepository<Doctor, Integer> getRepository() { return repo; }
}
