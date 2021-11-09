package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String address;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Visit> visits;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "patient_diagnosis",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "diagnosis_id")
    )
    private Set<Diagnosis> diagnoses;

    public Patient(String name, String surname, Date birthday, String address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.diagnoses = new HashSet<>();
    }

    @Override
    public String toString() {
        return "patient: id=" + id
                + " name=" + name
                + " surname=" + surname
                + " birthday=" + birthday
                + " address=" + address
                + " diagnoses=" + Arrays.toString(diagnoses.toArray());
    }
}
