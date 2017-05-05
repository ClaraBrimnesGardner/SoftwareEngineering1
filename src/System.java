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
    public System() throws Exception{
        this.database = new Database();
        createProject(database.getReservedName());
        Project OB = database.getProject(0);
        OB.createAssignment(database.getIllness());
        OB.createAssignment(database.getVacation());
        OB.createAssignment(database.getSeminars());
    }

    public String[] logIn(String ID) throws WrongInputException {
        Employee employee = database.getEmployee(ID);
        if (employee == null) {
            throw new WrongInputException ("Employee doesn't exist");
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
        Project OB = database.getProject(0);
        Assignment Illness = OB.getAssignmentByName("Illness");
        Illness.manAssignmentWithoutEndTime(employee);

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

    public static DayCalendar getThisDay () {
        Calendar calendar=new GregorianCalendar();
        int year=calendar.get(Calendar.YEAR);
        int week=calendar.get(Calendar.WEEK_OF_YEAR);
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        if (day==1) try {
            return new DayCalendar(new WeekCalendar(year,week),7);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        try {
            return new DayCalendar(new WeekCalendar(year,week),day-1);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeEmployee (String employeeID) throws WrongInputException {
        Employee employee1 = database.getEmployee(employeeID);
        if (employee.equals(employee1)) throw new WrongInputException("You can't delete yourself");
        database.deleteEmployee(employee1);
    }

    public void removeProject (int projectID) throws WrongInputException {
        Project project1 = database.getProject(projectID);
        if(project1 == null) throw new WrongInputException ("Project doesn't exist");
        if(!project1.projectLeader.equals(employee)) throw new WrongInputException("You are not project leader of this project");
        database.deleteProject(project1);
    }

    public void removeAssignment (String assignmentName) throws WrongInputException {
        database.deleteAssignment(database.getAssignment(assignmentName));
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

    public int convertToHalfHours(double hours) {
        hours *= 2;
        return ((int) hours);
    }

}