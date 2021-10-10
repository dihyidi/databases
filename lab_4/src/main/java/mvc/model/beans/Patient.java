package mvc.model.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Patient {
    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String address;
}
