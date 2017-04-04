/**
 * Created by sarad on 04-04-2017.
 */
public class Project {
    public String name;
    public int projectID;
    public Employee projectLeader;
    public System system;

    public Project (int projectID, System system) {
        this.projectID = projectID;
        this.system=system;
    }
}
