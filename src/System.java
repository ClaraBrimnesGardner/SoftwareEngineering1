/**
  * Created by clarabrimnesgardner on 27/03/2017.
 */
import java.util.*;

public class System {
    private boolean loggedIn = false;
    public List<Employee> employeeList;
    public List<Project> projectList;
    private String Test;

    public System () {
        this.employeeList = new ArrayList<Employee>();
        this.projectList = new ArrayList<Project>();
    }

    // Method to addEmployee
    public void addEmployee(Employee worker){
        if (!employeeList.contains(worker)) {
            employeeList.add(worker);
            worker.setSystem(this);
            // HEJ he h

        }
    }

    // Method to get list om employees
    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    // Method to get an employee with af specifik string
    public Employee employeeByID(String ID){
        for(int i=0;i<employeeList.size();i++){
            if(employeeList.get(i).getEmployeeID().equals(ID)) {
                return employeeList.get(i);
            }
        }
        return null;
    }

    public void employeeLogin(Employee worker) {
        if (employeeList.contains(worker)) {
            loggedIn = true;
        }
    }

    public void employeeLogoff() {
        loggedIn = false;
    }

    public boolean employeeLoggedIn() {
        return loggedIn;
    }
    }