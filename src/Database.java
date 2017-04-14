/**
 * Created by sarad on 12-04-2017.
 */

import java.util.*;

public class Database {
    public List<Employee> employeeList;
    public List<Project> projectList;

    int newProjectID;
    int newEmployeeID;

    // Constructor
    public Database () {
        this.employeeList = new ArrayList<Employee>();
        this.projectList = new ArrayList<Project>();

        this.newProjectID = 0;
        this.newEmployeeID = 0;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public Employee getEmployee(String ID) {
        for (Employee employee: employeeList) {
            if (employee.employeeID.equals(ID))
                return employee;
        }
        return null;
    }

    public Project getProject (int ID) {
        for (Project project:projectList){
            if (project.projectID==ID) return project;
        }
        return null;
    }


    public void addEmployee(Employee employee) throws WrongInputException {
        if (employee==null) throw new WrongInputException("Employee doesn't excist");
        employeeList.add(employee);
        employee.setDatabase(this);
    }

    protected Project addProject (Project project) throws WrongInputException {
        if (project==null) throw new WrongInputException("Project doesn't excist");
        project.projectID=newProjectID;
        newProjectID++;
        projectList.add(project);
        return project;
    }

    public int numberOfprojects () {
        return this.projectList.size();
    }

    public int numberOfemplyees () {
        return this.employeeList.size();
    }

}
