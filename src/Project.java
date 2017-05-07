/**
 * Created by sarad on 04-04-2017.
 */
import javax.xml.crypto.Data;
import java.util.*;

public class Project {
    public String name;
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


    public Assignment getAssignmentByName(String name) throws WrongInputException{
        for(Assignment assignment:database.getProjectAssignmentList(this)){
            if(assignment.getName().equals((name))){
                return assignment;
            }
        }
        throw new WrongInputException("Assignment doesn't exist");
    }

    // Setter methods
    public void setSystem(System newSystem){system = newSystem;
    }

    public void setProjectID(int newProjectID){
        projectID=newProjectID;
    }

    public void setProjectLeader(Employee projectLeader){
        if(this.projectLeader==null) {
            this.projectLeader = projectLeader;
        }
    }

    public void setDatabase(Database database){
        this.database=database;
    }
    public Database getDatabase(){
        return database;
    }

    // Method to create an assignment
    public void createAssignment(String name) throws WrongInputException{
        for (Assignment assignment: database.getProjectAssignmentList(this)){
            if (assignment.getName().equals((name))) throw new WrongInputException("Projectname is used");
        }
        Assignment newAssignment = new Assignment(name,this);
        getDatabase().addAssignment(newAssignment);

    }

}
