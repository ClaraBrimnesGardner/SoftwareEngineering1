/**
  * Created by clarabrimnesgardner on 27/03/2017.
 */

import javax.xml.crypto.Data;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class System {
    private Employee employee;
    private Database database;

    // Constructor
    public System () {
        this.database = new Database();
    }

    public String[] logIn(String ID) throws WrongInputException {
        Employee employee = database.getEmployee(ID);
        if (employee == null) {
            throw new WrongInputException ("Employee doesn't excist");
        }
        this.employee = employee;
        return new String[] {
                "Succesfully logged in as " + employee.employeeID + " with id: " + employee.employeeID
        };
    }

    public void logOff(){
        employee=null;
    }

    public void createEmployee (String ID) throws WrongInputException {
        for (Employee employee:database.employeeList){
            if(employee.getEmployeeID().equals((ID))) throw new WrongInputException("Employee ID is used");
        }
        Employee employee = new Employee(ID);
        database.addEmployee(employee);
    }

    public void createProject (String name) throws WrongInputException {
        for (Project project : database.getProjectList()){
            if (project.getName().equals((name))) throw new WrongInputException("Projectname is used");

        }
        Project project = new Project(name);
        database.addProject(project);
    }

    public void becomeProjectLeader(int ProjectID) throws OperationNotAllowedException{
        if(employee==(null)){
            throw new OperationNotAllowedException("LogIn to become projectleader");
        }
        employee.becomeProjectLeader(ProjectID);
    }

    public void registerTime(DayCalendar dayCalendar, int halfHours, int assignmentID) throws Exception{
        if(employee==null){
            throw new OperationNotAllowedException("LogIn to register time");
        }
        AssignmentEmployee currentAssignment = employee.getAssignmentEmployeeByID(assignmentID);
        if(currentAssignment==null){
            throw new OperationNotAllowedException("You are not manned to an assignment with the given ID");
        }
        currentAssignment.registerTime(dayCalendar, halfHours);
    }

    public boolean seekAssistance(String employeeID, String assignmentID, int year, int weekNumber, int bookedHours) throws WrongInputException {
        WeekCalendar weekCalendar = new WeekCalendar(year, weekNumber);
        WeekBooking booking = new WeekBooking(weekCalendar,bookedHours);
        Employee assistanceEmployee = database.getEmployee(employeeID);

        if (assistanceEmployee == null) throw new WrongInputException("Wrong employee name");
        if (!assistanceEmployee.isAvailable(weekCalendar,1,bookedHours)) throw new WrongInputException("Employee is not available");

        Assignment assignment = database.getAssignment(assignmentID);
        if (database.createBooking(assistanceEmployee, assignment, booking)) return true;

        return false;
    }

    public static DayCalendar getThisDay () throws WrongInputException {
        Calendar calendar=new GregorianCalendar();
        int year=calendar.get(Calendar.YEAR);
        int week=calendar.get(Calendar.WEEK_OF_YEAR);
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        if (day==7) return new DayCalendar(new WeekCalendar(year,week),1);
        return new DayCalendar(new WeekCalendar(year,week),day+1);
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