package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "visit")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private double price;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    public Visit(Date date, double price, Patient pat, Doctor doc) {
        this.patient = pat;
        this.doctor = doc;
        this.price = price;
        this.date = date;
    }

    @Override
    public String toString() {
        return "visit: id=" + id + " date=" + date + " price=" + price + " patientId=" + patient.getId() + " doctorId=" + doctor.getId();
    }
}
