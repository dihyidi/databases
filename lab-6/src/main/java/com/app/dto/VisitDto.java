package com.app.dto;

import com.app.domain.Doctor;
import com.app.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitDto {
    protected Integer id;
    private Date date;
    private double price;
    private Patient patient;
    private Doctor doctor;
}
