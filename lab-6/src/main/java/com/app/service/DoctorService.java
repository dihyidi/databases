package com.app.service;

import com.app.domain.Doctor;
import com.app.domain.Specialization;
import com.app.dto.DoctorDto;
import com.app.repo.DoctorRepo;
import com.app.repo.SpecializationRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DoctorService extends BaseService<Doctor, Integer, DoctorDto> {
    public DoctorRepo repo;
    private SpecializationRepo specRepo;

    @Override
    protected JpaRepository<Doctor, Integer> getRepository() { return repo; }

    @Override
    public Doctor convertDtoToEntity(DoctorDto dto) {
        Specialization spec = specRepo.getById(dto.getSpecializationId());
        return new Doctor(dto.getName(), dto.getExperienceYrs(), spec);
    }
}
