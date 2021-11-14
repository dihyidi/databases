package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "specialization")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "specialization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Doctor> doctors;

    public void addDoctor(Doctor doctor){
        doctor.setSpecialization(this);
        doctors.add(doctor);
    }

    @Override
    public String toString() {
        return "specialization: id=" + id + " name=" + name;
    }
}
