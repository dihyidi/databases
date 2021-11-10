package mvc.model.beans;

import lombok.Data;

import java.sql.Time;

@Data
public class WorkTime {
    private int id;
    private Time startTime;
    private Time endTime;
}
