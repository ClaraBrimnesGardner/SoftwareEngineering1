/**
 * Created by sarad on 04-04-2017.
 */
public class Project {
    public String name;
    private String projectID;
    public Employee projectLeader;
    public System system;

    public Project (String projectID) {
        this.projectID = projectID;
    }

    // Getter methods
    public String getProjectID(){
        return projectID;
    }
    public System getSystem(){
        return system;
    }

    // Setter methods
    public void setSystem(System newSystem){
        system=newSystem;
    }
}
