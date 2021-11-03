package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "patient")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Visit> visit;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "patient_diagnosis",
            joinColumns = { @JoinColumn(name = "patient_id") },
            inverseJoinColumns = { @JoinColumn(name = "diagnosis_id") }
    )
    Set<Diagnosis> patientDiagnosis = new HashSet<>();

    public Patient(String name, String surname, Date birthday, String address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
    }
}
