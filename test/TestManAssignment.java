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
        // Creates a system
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
        WeekCalendar week2 = new WeekCalendar(2017, 2);

        // manAssignment
        Assignment currentAssignment = currentProject.getAssignmentByName("test");
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week1,1),38);

        currentAssignment.manAssignment(SoftwareHouse.getEmployees().get(0),  week1,  1,  2);

        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID).size(),1);
        assertEquals(SoftwareHouse.getEmployees().get(0).getBookedHours(week1,1),2);
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week1,1),36);
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week2,1),38);
        assertEquals(SoftwareHouse.getProjects().get(0).getAssignmentList().get(0).getBookedTime(),2);

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
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week1, 1), 38);
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week2,1),38);

        currentAssignment.manAssignment(SoftwareHouse.getEmployees().get(0), week1, 2, 40);
        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID).size(), 1);
        assertEquals(SoftwareHouse.getEmployees().get(0).getAvailableHours(week1, 1), 0);
        assertEquals(SoftwareHouse.getEmployees().get(0).getBookedHours(week1, 1), 38);
        assertEquals(SoftwareHouse.getEmployees().get(0).getAvailableHours(week2, 1), 36);

        assertEquals(SoftwareHouse.getEmployees().get(0).getBookedHours(week2,1),2);
        assertEquals(SoftwareHouse.getProjects().get(0).getAssignmentList().get(0).getBookedTime(),40);
    }

    @Test
    public void manTwoPeopleToAssignment() throws WrongInputException{
        System SoftwareHouse = new System();
        // Adds an employee
        String ID = "Employee1";
        SoftwareHouse.createEmployee(ID);
        Employee employee1= SoftwareHouse.getEmployees().get(0);
        assertEquals(SoftwareHouse.getEmployees().size(), 1);

        // Adds another employee
        String ID2 = "Employee2";
        SoftwareHouse.createEmployee(ID2);
        Employee employee2 = SoftwareHouse.getEmployees().get(1);
        assertEquals(SoftwareHouse.getEmployees().size(),2);


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
        Assignment currentAssignment = currentProject.getAssignmentByName("test");

        // Set budgettet time
        currentAssignment.setBudgetedTime(60);

        // Create WeekCalendar
        WeekCalendar week1 = new WeekCalendar(2017, 1);
        WeekCalendar week2 = new WeekCalendar(2017, 2);

        // ManAssignment
        currentAssignment.manAssignment(employee1, week1,1,20);
        currentAssignment.manAssignment(employee2,week1,2,40);

        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID).size(), 1);
        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID2).size(), 1);

        assertEquals(employee1.getAvailableHours(week1,1),18);
        assertEquals(employee2.getAvailableHours(week1,2),36);
        assertEquals(employee2.getAvailableHours(week1,1),0);
        assertEquals(employee2.getAvailableHours(week2,1),36);

        assertEquals(SoftwareHouse.getProjects().get(0).getAssignmentList().get(0).getBookedTime(),60);
        assertEquals(currentAssignment.getBudgetedTime(),60);


    }


}
