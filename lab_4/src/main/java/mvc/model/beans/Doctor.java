package mvc.model.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private int id;
    private String name;
    private int experienceYrs;
    private int specializationId;
}
