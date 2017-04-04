/**
 * Created by clarabrimnesgardner on 27/03/2017.
 */
public class Employee {
    private String employeeID;
    private System system;

    // Constructor 
    public Employee(String ID){
        this.employeeID=ID;
    }
    //Test
    // Setter methods
    public void setSystem(System newSystem){this.system=newSystem;}

    // Getter methods 
    public String getEmployeeID(){
        return employeeID;
    }
    public System getSystem() {return system;}

    public static void addProject(Project project) {
        project.projectID=1234;
        system.projectList.add(project);
    }
}
