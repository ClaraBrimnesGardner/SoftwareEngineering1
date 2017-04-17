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

    public double availableHours(WeekCalendar startWeek, WeekCalendar endWeek) {
        double hours = 37.5*startWeek.weeksTo(endWeek);
        return hours - bookedHours(startWeek, endWeek);
    }

    public double bookedHours(WeekCalendar startWeek, WeekCalendar endWeek) {
        double bookedHours = 0;
        List<AssignmentEmployee> assignmentList = database.getAssignmentEmployeeList(employeeID);
        for (AssignmentEmployee assignment : assignmentList) {
            for (WeekCalendar week : assignment.getWeekList()) {
                if (week.getWeekNumber() <= endWeek.getWeekNumber() || week.getWeekNumber() >= startWeek.getWeekNumber()) {
                    bookedHours += week.getBookedHours();
                }
            }
        }
        return bookedHours;
    }
}