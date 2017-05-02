/**
 * Created by clarabrimnesgardner on 25/04/2017.
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRegisterHours {

    @Test
    public void testRegisterHours() throws Exception{
        // Creates a system
        System SoftwareHouse = new System();

        // Adds an employee
        String ID01="Employee01";
        SoftwareHouse.createEmployee(ID01);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        assertEquals(SoftwareHouse.getProjects().size(),1);
        Project currentProject = SoftwareHouse.getProjects().get(0);


        // Become projectLeader
        SoftwareHouse.logIn(ID01);
        Employee currentEmployee = SoftwareHouse.getCurrentEmployee();
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject.getProjectID());
        assertEquals(currentEmployee.getProjectLeaderList().size(),1);

        // Add an assignment
        String assignmentID="Assignment1";
        currentProject.createAssignment(assignmentID);
        assertEquals(currentProject.getAssignmentList().size(),1);
        Assignment currentAssignment = currentProject.getAssignmentByName(assignmentID);

        // Adds a weekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,1);

        // Mans the assignment
        currentAssignment.manAssignment(currentEmployee,week1,1,20);
        assertEquals(currentEmployee.getBookedHours(week1,1),20);
        assertEquals(currentAssignment.getBookedTime(),20);
        assertEquals(currentEmployee.getAvailableHours(week1,1),60);

        // Adds a dayCalendar
        DayCalendar day1 = new DayCalendar(week1,1);
        // Registers hours
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),0);
        currentEmployee.getAssignmentEmployeeList().get(0).registerTime(day1,8);
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),8);
    }

    @Test
    public void testRegisterHoursTwoDays() throws Exception{
        // Creates a system
        System SoftwareHouse = new System();

        // Adds an employee
        String ID01="Employee01";
        SoftwareHouse.createEmployee(ID01);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        assertEquals(SoftwareHouse.getProjects().size(),1);
        Project currentProject = SoftwareHouse.getProjects().get(0);

        // Become projectLeader
        SoftwareHouse.logIn(ID01);
        Employee currentEmployee = SoftwareHouse.getCurrentEmployee();
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject.getProjectID());
        assertEquals(currentEmployee.getProjectLeaderList().size(),1);

        // Add an assignment
        String assignmentID="Assignment1";
        currentProject.createAssignment(assignmentID);
        assertEquals(currentProject.getAssignmentList().size(),1);
        Assignment currentAssignment = currentProject.getAssignmentByName(assignmentID);

        // Adds a weekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,1);

        // Mans the assignment
        currentAssignment.manAssignment(currentEmployee,week1,1,20);
        assertEquals(currentEmployee.getBookedHours(week1,1),20);
        assertEquals(currentAssignment.getBookedTime(),20);
        assertEquals(currentEmployee.getAvailableHours(week1,1),60);

        // Adds a dayCalendar
        DayCalendar day1 = new DayCalendar(week1,1);
        // Registers hours
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),0);
        currentEmployee.getAssignmentEmployeeList().get(0).registerTime(day1,8);
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),8);

        // Adds another dayCalendar
        DayCalendar day2 = new DayCalendar(week1, 2);
        // Registers hours
        assertEquals(currentEmployee.getRegisteredHalfHours(day2),0);
        currentEmployee.getAssignmentEmployeeList().get(0).registerTime(day2,4);
        assertEquals(currentEmployee.getRegisteredHalfHours(day2),4);

        assertEquals(currentEmployee.getAssignmentEmployeeList().get(0).getDayRegistrationList().size(),2);
    }

    @Test
    public void testRegisterTwoTimes() throws Exception{
        // Creates a system
        System SoftwareHouse = new System();

        // Adds an employee
        String ID01="Employee01";
        SoftwareHouse.createEmployee(ID01);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        assertEquals(SoftwareHouse.getProjects().size(),1);
        Project currentProject = SoftwareHouse.getProjects().get(0);

        // Become projectLeader
        SoftwareHouse.logIn(ID01);
        Employee currentEmployee = SoftwareHouse.getCurrentEmployee();
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject.getProjectID());
        assertEquals(currentEmployee.getProjectLeaderList().size(),1);

        // Add an assignment
        String assignmentID="Assignment1";
        currentProject.createAssignment(assignmentID);
        assertEquals(currentProject.getAssignmentList().size(),1);
        Assignment currentAssignment = currentProject.getAssignmentByName(assignmentID);

        // Adds a weekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,1);

        // Mans the assignment
        currentAssignment.manAssignment(currentEmployee,week1,1,20);
        assertEquals(currentEmployee.getBookedHours(week1,1),20);
        assertEquals(currentAssignment.getBookedTime(),20);
        assertEquals(currentEmployee.getAvailableHours(week1,1),60);

        // Adds a dayCalendar
        DayCalendar day1 = new DayCalendar(week1,1);
        // Registers hours
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),0);
        currentEmployee.getAssignmentEmployeeList().get(0).registerTime(day1,4);
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),4);

        // Registers hours
        currentEmployee.getAssignmentEmployeeList().get(0).registerTime(day1,4);
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),8);
    }

    @Test
    public void testRegisterTwoManyHours() throws Exception{
        // Creates a system
        System SoftwareHouse = new System();

        // Adds an employee
        String ID01="Employee01";
        SoftwareHouse.createEmployee(ID01);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        assertEquals(SoftwareHouse.getProjects().size(),1);
        Project currentProject = SoftwareHouse.getProjects().get(0);

        // Become projectLeader
        SoftwareHouse.logIn(ID01);
        Employee currentEmployee = SoftwareHouse.getCurrentEmployee();
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject.getProjectID());
        assertEquals(currentEmployee.getProjectLeaderList().size(),1);

        // Add an assignment
        String assignmentID="Assignment1";
        currentProject.createAssignment(assignmentID);
        assertEquals(currentProject.getAssignmentList().size(),1);
        Assignment currentAssignment = currentProject.getAssignmentByName(assignmentID);

        // Adds a weekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,1);

        // Mans the assignment
        currentAssignment.manAssignment(currentEmployee,week1,1,20);
        assertEquals(currentEmployee.getBookedHours(week1,1),20);
        assertEquals(currentAssignment.getBookedTime(),20);
        assertEquals(currentEmployee.getAvailableHours(week1,1),60);

        // Adds a dayCalendar
        DayCalendar day1 = new DayCalendar(week1,1);
        // Registers hours
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),0);
        try{
            currentEmployee.getAssignmentEmployeeList().get(0).registerTime(day1,17);;
        } catch (TooManyHoursException e){
            assertEquals(e.getMessage(),"You have already registered too many hours today");
        }
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),0);
    }




}
