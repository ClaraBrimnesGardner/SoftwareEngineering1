/**
 * Created by clarabrimnesgardner on 27/03/2017.
 */
import java.util.*;
public class Employee {
    protected String employeeID;
    //protected System system;
    //protected List<Project> projectLeaderList;
    protected Database database;

    // Constructor 
    public Employee(String ID){
        this.employeeID=ID;
    }

    // Getter methods 
    public String getEmployeeID(){
        return employeeID;
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

    // Setter methods
    public void setDatabase(Database database){
        this.database=database;
    }

    // Method to become projectLeader
    public void becomeProjectLeader(int projectID){
        Project project=database.getProject(projectID);
        boolean projectFree = project.setProjectLeader(this);

    }

    public int availableHours(WeekCalendar weekCalendar, int duration) {
        int hours = 38*duration;
        return (hours - bookedHours(weekCalendar,duration));
    }

    public int bookedHours(WeekCalendar week, int duration) {

        // Setting the booked hours to 0
        int bookedHours = 0;
        // Setting the endWeek
        WeekCalendar endWeek = new WeekCalendar(week.getYear(),week.getWeekNumber());
        endWeek.increaseWeek(duration);

        // Retrieving a list of all assignments with the current employee
        List<AssignmentEmployee> assignmentList = database.getAssignmentEmployeeList(employeeID);
        // Looping over all assignments with the current employees
        for (AssignmentEmployee assignment : assignmentList) {
            // Getting all bookings for the current week
            for (WeekBooking booking : assignment.getWeekList()) {
                // Getting the booked hours
                if (booking.getWeekCalendar().before(endWeek)&& booking.getWeekCalendar().after(week)) {
                    bookedHours += booking.getBookedHours();
                }
            }
        }
        return bookedHours;
    }

}