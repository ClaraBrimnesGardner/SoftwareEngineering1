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

    // Method to addProject. The method returns true, if the project is succesfully added. Otherwise the function returns


    // Getter methods
    public String getEmployeeID(){
        return employeeID;
    }

    public static void addProject(Project project) {
        project.projectID=1234;
    }
}
