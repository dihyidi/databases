package com.app.dto;

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
    private int patientId;
    private int doctorId;
}
