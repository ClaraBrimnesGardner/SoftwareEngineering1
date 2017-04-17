/**
  * Created by clarabrimnesgardner on 27/03/2017.
 */

import javax.xml.crypto.Data;
import java.util.*;

public class System {
    private Employee employee;
    private Database database;

    // Constructor
    public System () {
        this.database = new Database();
    }

    /*
    public System(Database database) {
        this.database=database;
    }
    */

    public String[] logIn(String ID) throws WrongInputException {
        Employee employee = database.getEmployee(ID);
        if (employee == null) {
            throw new WrongInputException ("Employee doesn't excist");
        }
        this.employee = employee;
        // lav noget med projektleder
        return new String[] {
                "Succesfully logged in as " + employee.employeeID + " with id: " + employee.employeeID
        };
    }

    public void logOff(){
        employee=null;
    }


    public void createProject (String name) throws WrongInputException {
        for (Project project:database.projectList) {
            if (project.getName().equals((name))) throw new WrongInputException("Projectname is used");
        }
        Project project = new Project(name);
        database.addProject(project);
    }

    public void createEmployee (String ID) throws WrongInputException {
        for (Employee employee:database.employeeList){
            if(employee.getEmployeeID().equals((ID))) throw new WrongInputException("Employee ID is used");
        }
        Employee employee = new Employee(ID);
        database.addEmployee(employee);
    }

    // Getter methods
    public List<Project> getProjects(){
        return database.getProjectList();
    }

    public List<Employee> getEmployees(){
        return database.getEmployeeList();
    }

    public Employee getCurrentEmployee() {return employee;}

    public Database getDatabase() {
        return database;
    }

}