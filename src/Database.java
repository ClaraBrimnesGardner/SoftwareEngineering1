/**
 * Created by sarad on 12-04-2017.
 */

import java.util.*;

public class Database {
    public List<Employee> employeeList;
    public List<Project> projectList;
    private List<Assignment> assignmentList;
    public List<AssignmentEmployee> assignmentEmployeeList;

    int newProjectID;
    int newEmployeeID;

    // Constructor
    public Database () {
        this.employeeList = new ArrayList<Employee>();
        this.projectList = new ArrayList<Project>();
        this.assignmentList = new ArrayList<Assignment>();
        this.assignmentEmployeeList = new ArrayList<AssignmentEmployee>();

        this.newProjectID = 0;
        this.newEmployeeID = 0;
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

    public List<Assignment> getAssignmentList() {return assignmentList;}

    public List<Assignment> getProjectAssignmentList(Project project){
        List<Assignment> projectAssignmentList = new ArrayList<Assignment>();
        for(Assignment assignment: assignmentList) {
            if(assignment.getProject().equals(project))
                projectAssignmentList.add(assignment);
        }
        return projectAssignmentList;
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

    public void addProject (Project project) throws WrongInputException {
        if (project == null) throw new WrongInputException("Project doesn't excist");
        project.projectID = newProjectID;
        newProjectID++;
        projectList.add(project);
        project.setDatabase(this);
    }
    public void addAssignment(Assignment assignment) throws WrongInputException {
        if (assignment == null) throw new WrongInputException("Assignment doesn't exist");
        assignmentList.add(assignment);
        assignment.setDatabase(this);
    }

    public void addAssignmentEmployee(AssignmentEmployee assignmentEmployee) throws WrongInputException{
        if(assignmentEmployee==null) throw new WrongInputException("Assignment doesn't exist");

    }

    public int numberOfprojects () {
        return this.projectList.size();
    }

    public int numberOfemplyees () {
        return this.employeeList.size();
    }

    public List<Employee> getAvailableEmployees(WeekCalendar startWeek, int duration, int hours) {
        List<Employee> available = new ArrayList<Employee>();
        for (Employee employee : employeeList) {
            if (employee.availableHours(startWeek, duration) >= hours) {
                available.add(employee);
            }
        }
        return available;
    }


    public List<AssignmentEmployee> getAssignmentEmployeeList(String employeeID) {
        List<AssignmentEmployee> assignments = new ArrayList<AssignmentEmployee>();
        for (AssignmentEmployee assignment : assignmentEmployeeList) {
            if (assignment.getEmployee().employeeID == employeeID) {
                assignments.add(assignment);
            }
        }
        return assignments;
    }
}