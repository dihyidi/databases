package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "doctor")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "experience_yrs")
    private int experienceYrs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private Collection<Visit> visits;

    public Doctor(String name, int exp, Specialization spec) {
        this.name = name;
        this.experienceYrs = exp;
        this.specialization = spec;
    }

    @Override
    public String toString() {
        return "doctor: id=" + id + " name=" + name + " exp=" + experienceYrs + " specId=" + specialization.getId();
    }
}
