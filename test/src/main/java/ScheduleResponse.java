import java.util.ArrayList;
import java.util.List;

/**
 * Created by i81269 on 5/20/2016.
 */
public class ScheduleResponse {
    private String effectiveDate;
    private List<GroupSchedule> schedules = new ArrayList<GroupSchedule>();

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<GroupSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<GroupSchedule> schedules) {
        this.schedules = schedules;
    }

}