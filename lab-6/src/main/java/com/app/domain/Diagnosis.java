package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String protocol;

    @ManyToMany(mappedBy = "diagnoses")
    private List<Patient> patients;

    @Override
    public String toString() {
        return "diagnosis: id=" + id + " name=" + name + " protocol=" + protocol;
    }
}
