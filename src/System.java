/**
 * Created by clarabrimnesgardner on 27/03/2017.
 */

import java.util.*;
public class System {
    private List<Employee> employeeList=new ArrayList<Employee>();
    private List<Project> projectList=new ArrayList<Project>();
    // Method to addEmployee
    public void addEmployee(String ID){
        Employee employeeWithID = employeeByID(ID);
        if(employeeWithID==null) {
            Employee Worker = new Employee(ID);
            employeeList.add(Worker);
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

}
