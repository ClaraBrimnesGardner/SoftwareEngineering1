/**
 * Created by sarad on 04-04-2017.
 */
import java.util.*;

public class Project {
    private String name;
    public int projectID;
    public Employee projectLeader;
    public System system;
    private Database database;

    // Constructor
    public Project (String name) {
        this.name = name;
        this.projectLeader=null;
    }

    // Getter methods
    public int getProjectID(){
        return projectID;
    }

    public String getProjectName(){
        return name;
    }

    public System getSystem(){
        return system;
    }

    public String getName(){
        return name;
    }

    public List<Assignment> getAssignmentList(){
        return database.getProjectAssignmentList(this);
    }

    public Employee getProjectLeader() {
        if(projectLeader==null){
            return null;
        }
        return projectLeader;}


    public Assignment getAssignmentByName(String name){
        for(Assignment assignment:database.getAssignmentList()){
            if(assignment.getName().equals(name)){
                return assignment;
            }
        }
        return null;
    }

    // Setter methods
    public void setSystem(System newSystem){system = newSystem;
    }

    public boolean setProjectLeader(Employee projectLeader){
        if(this.projectLeader==null) {
            this.projectLeader = projectLeader;
            return true;
        }
        return false;

    }

    public void setDatabase(Database database){
        this.database=database;
    }


    // Method to create an assignment
    public void createAssignment(String name) throws WrongInputException{
        for (Assignment assignment: database.getProjectAssignmentList(this)){
            if (assignment.getName().equals((name))) throw new WrongInputException("Projectname is used");
        }
        Assignment newAssignment = new Assignment(name,this);
        database.addAssignment(newAssignment);

    }

    public void manAssignment(Assignment assignment, Employee employee) throws OperationNotAllowedException {
        if (!(system.getCurrentEmployee() == projectLeader)) {
            throw new OperationNotAllowedException("Only the project leader has authority to do this");
        }

    }

    // Method to set budgeted time for an assignment (given by name)
}
