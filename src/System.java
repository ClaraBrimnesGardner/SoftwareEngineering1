/**
  * Created by clarabrimnesgardner on 27/03/2017.
 */

import java.util.*;

public class System {
    public Employee employee1;
    private Database database;

    // Constructor
    public System () {
        this.database = new Database();
    }

    public System(Database database) {
        this.database=database;
    }

    public String[] logIn(String ID) throws WrongInputException {
        Employee employee=database.getEmployee(ID);
        if (employee==null) throw new WrongInputException ("Employee doesn't excist");
        employee1=employee;
        // lav noget med projektleder
        return new String[] {
                "Succesfully logged in as " + employee.employeeID + " with id: " + employee.employeeID
        };
    }

    public void createProject (String name) throws WrongInputException {
        for (Project project:database.projectList) {
            if (project.name.equals(name)) throw new WrongInputException("Project name is used");
        }
        Project project = new Project(name);
        database.addProject(project);
    }

    public void createEmployee (String name) throws WrongInputException {
        Employee employee = new Employee(name);
        database.addEmployee(employee);
    }

}