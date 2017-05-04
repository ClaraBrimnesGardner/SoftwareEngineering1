/**
 * Created by sarad on 12-04-2017.
 */

import java.util.*;
import java.lang.System;

public class Database {
    public List<Employee> employeeList;
    public List<Project> projectList;
    private List<Assignment> assignmentList;
    public List<AssignmentEmployee> assignmentEmployeeList;

    int newProjectID;
    int newTaskID;

    // Constructor
    public Database () {
        this.employeeList = new ArrayList<Employee>();
        this.projectList = new ArrayList<Project>();
        this.assignmentList = new ArrayList<Assignment>();
        this.assignmentEmployeeList = new ArrayList<AssignmentEmployee>();

        this.newProjectID = 0;
        this.newTaskID=0;
    }

    // Methods to get lists
    public List<Assignment> getAssignmentList() {return assignmentList;}

    public List<AssignmentEmployee> getAssignmentEmployeeList(String employeeID) {
        List<AssignmentEmployee> assignments = new ArrayList<AssignmentEmployee>();
        for (AssignmentEmployee assignment : assignmentEmployeeList) {
            if (assignment.getEmployee().getEmployeeID()==employeeID) {
                assignments.add(assignment);
            }
        }
        return assignments;
    }

    public List<Employee> getAvailableEmployees(WeekCalendar startWeek, int duration, int hours) {
        List<Employee> available = new ArrayList<Employee>();
        for (Employee employee : employeeList) {
            if (employee.getAvailableHours(startWeek, duration) >= hours) {
                available.add(employee);
            }
        }
        return available;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public List<Project> getProjectLeaderList(Employee employee){
        List<Project> projectLeaderList = new ArrayList<Project>();
        for( Project project: projectList){
            if(project.getProjectLeader()!=null && project.getProjectLeader().equals(employee)){
                projectLeaderList.add(project);
            }

        }
        return projectLeaderList;
    }

    public List<Project> getAvailableProjects(){
        List<Project> freeProjectList = new ArrayList<>();
        for(Project project: projectList){
            if(project.getProjectLeader()==null) {
                freeProjectList.add(project);
            }
        }
        return freeProjectList;
    }

    public List<Assignment> getProjectAssignmentList(Project project){
        List<Assignment> projectAssignmentList = new ArrayList<Assignment>();
        for(Assignment assignment: assignmentList) {
            if(assignment.getProject().equals(project))
                projectAssignmentList.add(assignment);
        }
        return projectAssignmentList;
    }

    // Methods to get objects
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

    public Assignment getAssignment(String ID) {
        for(Assignment assignment: assignmentList) {
            if(assignment.name.equals(ID)) return assignment;
        }
        return null;
    }
    // Methods to add objects
    public void addAssignment(Assignment assignment) throws WrongInputException {
        if (assignment == null) throw new WrongInputException("Assignment doesn't exist");
        assignmentList.add(assignment);
        assignment.setDatabase(this);
    }

    public void addAssignmentEmployee(AssignmentEmployee assignmentEmployee) throws WrongInputException {
        if (assignmentEmployee == null) throw new WrongInputException("Assignment doesn't exist");
        assignmentEmployee.setTaskID(newTaskID);
        newTaskID++;
        assignmentEmployeeList.add(assignmentEmployee);
    }

    public void addEmployee(Employee employee) throws WrongInputException {
        if (employee==null) throw new WrongInputException("Employee doesn't excist");
        employeeList.add(employee);
        employee.setDatabase(this);
    }

    public void addProject (Project project) throws WrongInputException {
        if (project == null) throw new WrongInputException("Project doesn't excist");
        project.setProjectID(newProjectID);
        newProjectID++;
        projectList.add(project);
        project.setDatabase(this);
    }

    public boolean createBooking(Employee employee, Assignment assignment, WeekBooking booking) throws WrongInputException {
        if (employee == null) throw new WrongInputException("Employee does not exist");
        if (assignment == null) throw new WrongInputException("Assignment does not exist");

        AssignmentEmployee task = new AssignmentEmployee(employee,assignment);
        if (task.addBooking(booking)) {
            assignmentEmployeeList.add(task);
            return true;
        }

        return false;
    }

    public AssignmentEmployee getAssignmentEmployeeByNameAndEmployee(String name, Employee employee) {
        for (AssignmentEmployee assignmentEmployee : assignmentEmployeeList) {
            if ((assignmentEmployee.getAssignment().getName() == name) && (assignmentEmployee.employee.equals(employee))) {
                return assignmentEmployee;
            }
        }
        return null;
    }


    public int getNumberOfProjects () {
        return this.projectList.size();
    }

    public int getNumberOfEmployees () {
        return this.employeeList.size();
    }


    public void deleteEmployee(Employee employee) throws WrongInputException {
        if (employee==null) throw new WrongInputException ("Employee doesn't exist");
        if (!employeeList.remove(employee)){
            throw new WrongInputException ("Employee doesn't exist");
        }
    }
}