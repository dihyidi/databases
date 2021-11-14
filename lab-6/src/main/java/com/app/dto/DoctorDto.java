package com.app.dto;

import com.app.domain.Specialization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {
    protected Integer id;
    private String name;
    private int experienceYrs;
    private Specialization specialization;
}
