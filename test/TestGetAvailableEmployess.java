import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

/**
 * Created by Tobias on 17/04/2017.
 */


public class TestGetAvailableEmployess {
    /*
    Test that getAvailableEmployees returns the correct number of employees when no employees are booked
     */
    @Test
    public void testGetTwoEmployess() throws Exception {
        System SoftwareHouse = new System();
        // Adds an employee
        String ID="Employee1";
        SoftwareHouse.createEmployee(ID);
        // Adds another employee
        String ID2 = "Employee2";
        SoftwareHouse.createEmployee(ID2);
        SoftwareHouse.createProject("test");

        WeekCalendar week1 = new WeekCalendar(2017,2);
        SoftwareHouse.logIn(ID2);
        assertEquals(80,SoftwareHouse.getEmployees().get(0).getAvailableHours(week1,1));

        assertEquals(0,SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,81).size());

        assertEquals(2,SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,38).size());
        assertEquals(0,SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,81).size());
        assertEquals(80,SoftwareHouse.getCurrentEmployee().getAvailableHours(week1,1));


    }

    /*
    Test that getAvailable employees returns a employee before any booking, and not after the booking, when to much time is demanded
     */
    @Test
    public void testGetAvailableEmployeesBooking() throws Exception{
        // Creates a system
        System SoftwareHouse = new System();

        // Adds an employee
        String ID01="Employee01";
        SoftwareHouse.createEmployee(ID01);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        assertEquals(SoftwareHouse.getProjects().size(),2);
        Project currentProject = SoftwareHouse.getProjects().get(1);


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

        // getAvailable employees
        WeekCalendar week1=new WeekCalendar(2017,1);
        List<Employee> availableEmployees = SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,20);
        assertEquals(availableEmployees.size(),1);

        // manAssignment
        currentAssignment.setBudgetedTime(20);
        currentAssignment.manAssignment(currentEmployee,week1,1,20);
        assertEquals(currentEmployee.getAvailableHours(week1,1),60);

        // getAvailable employee
        List<Employee> availableEmployees2=SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,61);
        assertEquals(availableEmployees2.size(),0);

        // Checks that the employee is available for 18 hours
        List<Employee> availableEmployees3=SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,60);
        assertEquals(availableEmployees3.size(),1);





    }
}
