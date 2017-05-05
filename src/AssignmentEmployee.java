import java.util.*;
import java.lang.System;

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


    public AssignmentEmployee(Employee employee, Assignment assignment) {
        this.taskID = taskID;
        this.employee = employee;
        this.assignment = assignment;
    }

    //Getter methods
    public List<WeekBooking> getWeekBookings() {
        return weekBookings;
    }

    public Assignment getAssignment() {
        return assignment;
    }


    public List<WeekCalendar> getBookedWeeks(){
        List<WeekCalendar> bookedWeeks = new ArrayList<>();
        for(WeekBooking weekBooking:getWeekBookings()){
            bookedWeeks.add(weekBooking.getWeekCalendar());
        }
        return bookedWeeks;
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
    public void registerTime(DayCalendar dayCalendar, int halfHours) throws Exception{
        if(employee.getRegisteredHalfHours(dayCalendar)+halfHours>employee.database.getMAX_REGISTERED_HALF_HOURS()){
            throw new TooManyHoursException("You have registered too many hours today");
        }
        if(!getBookedWeeks().contains(dayCalendar.getWeekCalendar())){
         throw new OperationNotAllowedException("You are not booked to this assignment in this week");
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