package com.app.service;

import com.app.domain.Doctor;
import com.app.domain.Patient;
import com.app.domain.Visit;
import com.app.dto.VisitDto;
import com.app.repo.DoctorRepo;
import com.app.repo.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.app.repo.VisitRepo;

@AllArgsConstructor
@Service
public class VisitService extends BaseService<Visit, Integer, VisitDto> {
    public VisitRepo repo;
    private PatientRepo patRepo;
    private DoctorRepo docRepo;

    @Override
    protected JpaRepository<Visit, Integer> getRepository() { return repo; }

    @Override
    protected Visit convertDtoToEntity(VisitDto visitDto) {
        Patient pat = patRepo.getById(visitDto.getPatientId());
        Doctor doc = docRepo.getById(visitDto.getDoctorId());
        return new Visit(visitDto.getDate(), visitDto.getPrice(), pat, doc);
    }
}
