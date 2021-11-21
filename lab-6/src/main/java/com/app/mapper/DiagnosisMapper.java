package com.app.mapper;

import com.app.domain.Diagnosis;
import com.app.dto.DiagnosisDto;
import org.springframework.stereotype.Component;

@Component
public class DiagnosisMapper implements BaseMapper<Diagnosis, DiagnosisDto> {
    @Override
    public DiagnosisDto mapEntityToDto(Diagnosis diagnosis) {
        return new DiagnosisDto(diagnosis.getId(), diagnosis.getName(), diagnosis.getProtocol());
    }
}
