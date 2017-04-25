import java.util.*;

/**
 * Created by Tobias on 17/04/2017.
 */

public class AssignmentEmployee {
    private int TaskID;
    private Employee employee;
    private List<WeekBooking> weekBookings = new ArrayList<>();

    public AssignmentEmployee(Employee employee) {
        this.employee = employee;
    }
    //Getter methods
    public List<WeekBooking> getWeekList() {
        return weekBookings;
    }

    public Employee getEmployee() {
        return employee;
    }

    // Setter methods
    public void setTaskID(int TaskID){
        this.TaskID=TaskID;
    }

    public void addBooking(WeekBooking weekBooking) {
        weekBookings.add(weekBooking);
    }





}