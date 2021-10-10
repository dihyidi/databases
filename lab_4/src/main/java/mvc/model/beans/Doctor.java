package mvc.model.beans;

import lombok.Data;

@Data
public class Doctor {
    private int id;
    private String name;
    private int experienceYrs;
    private int specializationId;
}
