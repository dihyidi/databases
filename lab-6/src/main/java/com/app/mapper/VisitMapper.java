package com.app.mapper;

import com.app.domain.Visit;
import com.app.dto.VisitDto;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper implements BaseMapper<Visit, VisitDto> {
    @Override
    public VisitDto mapEntityToDto(Visit visit) {
        return new VisitDto(visit.getId(), visit.getDate(), visit.getPrice(), visit.getPatient().getId(), visit.getDoctor().getId());
    }
}
