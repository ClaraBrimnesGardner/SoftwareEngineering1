/**
 * Created by clarabrimnesgardner on 25/04/2017.
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRegisterHours {

    @Test
    public void testRegisterHours() throws WrongInputException{
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
        assertEquals(currentEmployee.getAvailableHours(week1,1),18);

        // Adds a dayCalendar
        DayCalendar day1 = new DayCalendar(week1,1);
        // Registers hours
        assertEquals(currentEmployee.getRegisteredHours(day1),0);
        currentEmployee.getAssignmentEmployeeList().get(0).registerTime(day1,8);
        assertEquals(currentEmployee.getRegisteredHours(day1),8);
    }

    @Test
    public void testRegisterHoursTwoProjects() throws WrongInputException{
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

        // Adds another project
        String projectID2="Project02";
        SoftwareHouse.createProject(projectID2);
        assertEquals(SoftwareHouse.getProjects().size(),2);
        Project project2 = SoftwareHouse.getProjects().get(1);


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
        assertEquals(currentEmployee.getAvailableHours(week1,1),18);

        // Adds a dayCalendar
        DayCalendar day1 = new DayCalendar(week1,1);
        // Registers hours
        assertEquals(currentEmployee.getRegisteredHours(day1),0);
        currentEmployee.getAssignmentEmployeeList().get(0).registerTime(day1,8);
        assertEquals(currentEmployee.getRegisteredHours(day1),8);


    }
}
