package com.app.mapper;

import com.app.domain.Specialization;
import com.app.dto.SpecializationDto;
import org.springframework.stereotype.Component;

@Component
public class SpecializationMapper implements BaseMapper<Specialization, SpecializationDto> {
    @Override
    public SpecializationDto mapEntityToDto(Specialization specialization) {
        return new SpecializationDto(specialization.getId(), specialization.getName());
    }
}
