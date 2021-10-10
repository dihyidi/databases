package mvc.model.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Visit {
    private int id;
    private int patientId;
    private int doctorId;
    private Date date;
    private double price;
}
