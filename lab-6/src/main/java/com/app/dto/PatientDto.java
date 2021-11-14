package com.app.dto;

import com.app.domain.Diagnosis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private Integer id;
    private String name;
    private String surname;
    private Date birthday;
    private String address;
    private Set<Diagnosis> diagnoses;
}
