/**
 * Created by clarabrimnesgardner on 27/03/2017.
 */

public class Employee {
    protected String employeeID;
    protected System system;

    // Constructor 
    public Employee(String ID){
        this.employeeID=ID;
    }

    // Getter methods 
    public String getEmployeeID(){
        return employeeID;
    }
    public System getSystem() {return system;}

}
