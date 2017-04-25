import java.util.*;

/**
 * Created by Tobias on 17/04/2017.
 */

public class AssignmentEmployee {
    private int TaskID;
    private Employee employee;
    private List<WeekBooking> weekBookings = new ArrayList<>();
    private List<DayRegistration> dayRegistrationList = new ArrayList<>();

    public AssignmentEmployee(Employee employee) {
        this.employee = employee;
    }

    //Getter methods
    public List<WeekBooking> getWeekList() {
        return weekBookings;
    }

    public List<DayRegistration> getDayRegistrationList(){return dayRegistrationList;}

    public Employee getEmployee() {
        return employee;
    }

    public int getAssignmentEmployeeByID(int TaskID){
        return TaskID;
    }



    // Setter methods
    public void setTaskID(int TaskID){
        this.TaskID=TaskID;
    }

    public void addBooking(WeekBooking weekBooking) {
        weekBookings.add(weekBooking);
    }

    // Method to register time
    public void registerTime(DayCalendar dayCalendar, int hours){
        DayRegistration newDayRegistration = new DayRegistration(dayCalendar, hours);
        dayRegistrationList.add(newDayRegistration);

    }







}