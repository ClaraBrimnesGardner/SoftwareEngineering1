import java.util.*;

/**
 * Created by Tobias on 17/04/2017.
 */

public class AssignmentEmployee {
    private int TaskID;
    private Employee employee;
    private List<WeekBooking> weekBookings = new ArrayList<WeekBooking>();

    public AssignmentEmployee(Employee employee) {
        this.employee = employee;
        this.TaskID = TaskID;
    }

    public List<WeekBooking> getWeekList() {
        return weekBookings;
    }

    public Employee getEmployee() {
        return employee;
    }



}