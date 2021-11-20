package com.app.service;

import com.app.domain.Specialization;
import com.app.dto.SpecializationDto;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.app.repo.SpecializationRepo;

@AllArgsConstructor
@Service
public class SpecializationService extends BaseService<Specialization, Integer, SpecializationDto> {
    public SpecializationRepo repo;
    @Override
    protected JpaRepository<Specialization, Integer> getRepository() { return repo; }

    @Override
    protected Specialization convertDtoToEntity(SpecializationDto specializationDto) {
        return new Specialization(specializationDto.getName());
    }
}
