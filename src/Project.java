/**
 * Created by sarad on 04-04-2017.
 */

public class Project {
    private String name;
    public int projectID;
    public Employee projectLeader;
    public System system;

    // Constructor
    public Project (String name) {
        this.name = name;
    }

    // Getter methods
    public int getProjectID(){
        return projectID;
    }
    public System getSystem(){
        return system;
    }
    public String getName(){
        return name;
    }

    // Setter methods
    public void setSystem(System newSystem){
        system=newSystem;
    }
}
