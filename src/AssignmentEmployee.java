import java.util.*;

/**
 * Created by Tobias on 17/04/2017.
 */


public class AssignmentEmployee {
    private static final int MAX_REGISTERED_HALF_HOURS= 16;
    public int taskID;
    public Employee employee;
    private List<WeekBooking> weekBookings = new ArrayList<>();
    private List<DayRegistration> dayRegistrationList = new ArrayList<>();
    private Assignment assignment;

    public Assignment getAssignment() {
        return assignment;
    }

    public AssignmentEmployee(Employee employee, Assignment assignment) {
        this.taskID = taskID;
        this.employee = employee;
        this.assignment = assignment;
    }

    //Getter methods
    public List<WeekBooking> getWeekList() {
        return weekBookings;
    }

    public List<DayRegistration> getDayRegistrationList(){return dayRegistrationList;}

    public Employee getEmployee() {
        return employee;
    }

    public int getTaskID(){
        return taskID;
    }

    // Setter methods
    public void setTaskID(int TaskID){
        this.taskID=TaskID;
    }

    public boolean addBooking(WeekBooking weekBooking) {
        if(weekBookings.add(weekBooking)) {
            return true;
        }
        return false;
    }

    // Method to register time
    public void registerTime(DayCalendar dayCalendar, int halfHours) throws TooManyHoursException{
        if(employee.getRegisteredHalfHours(dayCalendar)+halfHours>MAX_REGISTERED_HALF_HOURS){
            throw new TooManyHoursException("You have registered too many hours today");
        }
        for(DayRegistration dayRegistration:dayRegistrationList){
            if (dayRegistration.getDayCalendar().equals(dayCalendar)){
                dayRegistration.addHours(halfHours);
                return;
            }
        }
        DayRegistration newDayRegistration = new DayRegistration(dayCalendar, halfHours);
        dayRegistrationList.add(newDayRegistration);

    }







}