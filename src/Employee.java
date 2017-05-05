/**
 * Created by clarabrimnesgardner on 27/03/2017.
 */
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;
import java.lang.System;

public class Employee {
    private static final int MAX_REGISTERED_HALF_HOURS= 16;
    protected String employeeID;
    protected Database database;

    // Constructor 
    public Employee(String ID){
        this.employeeID=ID;
    }

    // Getter methods 
    public String getEmployeeID(){
        return employeeID;
    }

    public List<AssignmentEmployee> getAssignmentEmployeeList(){
       return database.getAssignmentEmployeeList(employeeID);
    }

    public List<Project> getProjectLeaderList(){
        List<Project> projectLeaderList;
        projectLeaderList=database.getProjectLeaderList(this);
        return projectLeaderList;
    }

    public Project getProjectByName(String name){
        for(Project project:database.getProjectLeaderList(this)){
            if(project.getProjectName().equals(name)){
                return project;
            }
        }
        return null;
    }

    public AssignmentEmployee getAssignmentEmployeeByID(int ID){
        for(AssignmentEmployee assignmentEmployee:getAssignmentEmployeeList()){
            if(assignmentEmployee.getTaskID()==ID){
                return assignmentEmployee;
            }
        }
        return null;
    }


    // Setter methods
    public void setDatabase(Database database){
        this.database=database;
    }

    // Method to become projectLeader
    public void becomeProjectLeader(int projectID){
        Project project=database.getProject(projectID);
        project.setProjectLeader(this);

    }

    public int getAvailableHours(WeekCalendar weekCalendar, int duration) {
        int halfHours = 80*(duration);
        return (halfHours - getBookedHours(weekCalendar,duration));
    }

    public boolean isAvailable (WeekCalendar startWeek, int duration, int hours) {
        if (getAvailableHours(startWeek, duration) >= hours) {
            return true;
        }
        return false;
    }

    public int getBookedHours(WeekCalendar week, int duration) {
        // Setting the booked hours to 0
        int bookedHalfHours = 0;
        // Setting the endWeek

        WeekCalendar endWeek=new WeekCalendar(week.getYear(),week.getWeekNumber());
        endWeek=endWeek.increaseWeek(duration-1);

        // Retrieving a list of all assignments with the current employee
        List<AssignmentEmployee> assignmentList = getAssignmentEmployeeList();
        // Looping over all assignments with the current employees
        for (AssignmentEmployee assignment : assignmentList) {
            // Getting all bookings for the current week
            for (WeekBooking booking : assignment.getWeekBookings()) {
                // Getting the booked hours
                if (booking.getWeekCalendar().before(endWeek)&& booking.getWeekCalendar().after(week)) {
                    bookedHalfHours += booking.getBookedHours();
                }
            }
        }
        return bookedHalfHours;
    }

    public int getRegisteredHalfHours(DayCalendar dayCalendar){
        int registeredHalfHours=0;
        for(AssignmentEmployee assignmentEmployee:getAssignmentEmployeeList()) {
            for (DayRegistration dayRegistration : assignmentEmployee.getDayRegistrationList()){
                if (dayCalendar.equals(dayRegistration.getDayCalendar())) {
                    registeredHalfHours += dayRegistration.getRegisteredHalfHours();
                }
            }
        }
        return registeredHalfHours;
    }

    public void registerIllness(DayCalendar dayCalendar,int  halfHours) throws TooManyHoursException{
        if(getRegisteredHalfHours(dayCalendar)+halfHours>database.getMAX_REGISTERED_HALF_HOURS()){
            throw new TooManyHoursException("You have registered too many hours today");
        }
        AssignmentEmployee Illness = database.getAssignmentEmployeeByNameAndEmployee("Illness", this);
        DayRegistration newDayRegistration = new DayRegistration(dayCalendar, halfHours);
        List<DayRegistration> dayRegistrationList = Illness.getDayRegistrationList();
        dayRegistrationList.add(newDayRegistration);

    }

    public void bookVacation(WeekCalendar week, int duration, int hours) throws Exception{
        String ID = database.getVacation();
        Assignment Vacation = database.getAssignment(ID);
        Vacation.manAssignment(this, week, duration, hours);

    }

}