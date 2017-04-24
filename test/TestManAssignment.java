/**
 * Created by clarabrimnesgardner on 24/04/2017.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestManAssignment {
    /*
    Tests that the method manAssignment books an employee for the desired number of hours in the correct week
     */
    @Test
    public void testManAssignment() throws WrongInputException{
        System SoftwareHouse = new System();
        // Adds an employee
        String ID="Employee1";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project

        SoftwareHouse.createProject("test");
        // Login as employee
        SoftwareHouse.logIn(ID);
        assertEquals(SoftwareHouse.getCurrentEmployee().getEmployeeID(),ID);
        assertEquals(SoftwareHouse.getCurrentEmployee(),SoftwareHouse.getEmployees().get(0));

        // Become projectLeader

        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(),0);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(0);
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(),1);

        // Create an assignment
        Project currentProject = SoftwareHouse.getCurrentEmployee().getProjectLeaderList().get(0);
        currentProject.createAssignment("test");
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("test").getAssignmentList().size(), 1);


        // Create WeekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,1);
        WeekCalendar week2 = new WeekCalendar(2017, 1);

        // manAssignment
        Assignment currentAssignment = currentProject.getAssignmentByName("test");
        assertEquals(SoftwareHouse.getCurrentEmployee().availableHours(week1,1),38);

        currentAssignment.manAssignment(SoftwareHouse.getEmployees().get(0),  week1,  1,  2);

        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID).size(),1);
        assertEquals(SoftwareHouse.getEmployees().get(0).bookedHours(week1,1),2);
        assertEquals(SoftwareHouse.getCurrentEmployee().availableHours(week1,1),36);

    }
    @Test
    public void testManTwoWeekAssignment() throws WrongInputException {
        System SoftwareHouse = new System();
        // Adds an employee
        String ID = "Employee1";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(), 1);

        // Adds a project

        SoftwareHouse.createProject("test");
        // Login as employee
        SoftwareHouse.logIn(ID);
        assertEquals(SoftwareHouse.getCurrentEmployee().getEmployeeID(), ID);
        assertEquals(SoftwareHouse.getCurrentEmployee(), SoftwareHouse.getEmployees().get(0));

        // Become projectLeader

        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 0);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(0);
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 1);

        // Create an assignment
        Project currentProject = SoftwareHouse.getCurrentEmployee().getProjectLeaderList().get(0);
        currentProject.createAssignment("test");
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("test").getAssignmentList().size(), 1);


        // Create WeekCalendar
        WeekCalendar week1 = new WeekCalendar(2017, 1);
        WeekCalendar week2 = new WeekCalendar(2017, 2);

        // manAssignment
        Assignment currentAssignment = currentProject.getAssignmentByName("test");
        assertEquals(SoftwareHouse.getCurrentEmployee().availableHours(week1, 1), 38);
        assertEquals(SoftwareHouse.getCurrentEmployee().availableHours(week2,1),38);

        currentAssignment.manAssignment(SoftwareHouse.getEmployees().get(0), week1, 2, 40);
        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID).size(), 1);
        assertEquals(SoftwareHouse.getEmployees().get(0).availableHours(week1, 1), 0);
        //assertEquals(SoftwareHouse.getEmployees().get(0).bookedHours(week1, 1), 38);
        //assertEquals(SoftwareHouse.getEmployees().get(0).availableHours(week2, 1), 36);

        //assertEquals(SoftwareHouse.getEmployees().get(0).bookedHours(week2,1),2);
    }
}
