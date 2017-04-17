/**
 * Created by clarabrimnesgardner on 27/03/2017.
 */
import java.util.*;
public class Employee {
    protected String employeeID;
    //protected System system;
    protected List<Project> projectLeaderList;
    protected Database database;

    // Constructor 
    public Employee(String ID){
        this.employeeID=ID;
        projectLeaderList = new ArrayList<Project>();

    }

    // Getter methods 
    public String getEmployeeID(){
        return employeeID;
    }
    //public System getSystem() {return system;}
    public List<Project> getProjectLeaderList(){
        return projectLeaderList;
    }

    // Setter methods
    public void setDatabase(Database database){
        this.database=database;
    }

    // Method to become projectLeader
    public void becomeProjectLeader(int projectID){
        Project project=database.getProject(projectID);
        boolean projectFree = project.setProjectLeader(this);
        if(projectFree==true){
            projectLeaderList.add(project);
        }
    }

    public double availableHours(int startWeek, int endWeek) {
        double hours = 37.5*(endWeek - startWeek);
        return hours - bookedHours();
    }

    private double bookedHours() {
        double bookedHours = 0;
        List<AssignmentEmployee> assignmentList = database.getAssignmentEmployeeList();
        for (AssignmentEmployee assignment : assignmentList) {
            //tæller

            bookedHours++;
        }
        return bookedHours;
    }
}