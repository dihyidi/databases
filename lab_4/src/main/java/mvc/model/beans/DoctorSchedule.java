package mvc.model.beans;

import lombok.Data;

@Data
public class DoctorSchedule {
    private int doctorId;
    private WorkSchedule schedule;
}
