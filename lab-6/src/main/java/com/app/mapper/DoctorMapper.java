package com.app.mapper;

import com.app.domain.Doctor;
import com.app.dto.DoctorDto;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper implements BaseMapper<Doctor, DoctorDto> {
    @Override
    public DoctorDto mapEntityToDto(Doctor doctor) {
        return new DoctorDto(doctor.getId(), doctor.getName(), doctor.getExperienceYrs(), doctor.getSpecialization().getId());
    }
}
