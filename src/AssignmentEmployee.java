import java.util.*;

/**
 * Created by Tobias on 17/04/2017.
 */

public class AssignmentEmployee {
    private int TaskID;
    private Employee employee;
    private List<WeekCalendar> weekList = new ArrayList<WeekCalendar>();

    public AssignmentEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<WeekCalendar> getWeekList() {
        return weekList;
    }

    public Employee getEmployee() {
        return employee;
    }



}