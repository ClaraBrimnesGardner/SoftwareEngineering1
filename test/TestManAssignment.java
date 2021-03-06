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
    public void testManAssignment() throws Exception{
        // Creates a system
        System SoftwareHouse = new System();
        // Adds an employee
        String ID="CBG";
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
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(1);
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(),1);

        // Create an assignment
        Project currentProject = SoftwareHouse.getCurrentEmployee().getProjectLeaderList().get(0);
        currentProject.createAssignment("test");
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("test").getAssignmentList().size(), 1);

        // Create WeekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,1);
        WeekCalendar week2 = new WeekCalendar(2017, 2);

        // Man assignment
        Assignment currentAssignment = currentProject.getAssignmentByName("test");
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week1,1),80);
        currentAssignment.setBudgetedTime(80);

        DayCalendar day1 = new DayCalendar(new WeekCalendar(2017, 6), 2);
        try {
            SoftwareHouse.getDatabase().getAssignmentEmployeeList("CBG").get(0).registerTime(day1, -30);
        } catch (TooManyHoursException e){
            assertEquals("You can't register less than 0 hours", e.getMessage());
        }

        currentAssignment.manAssignment(SoftwareHouse.getEmployees().get(0),  week1,  1,  2);

        DayCalendar day2 = new DayCalendar(new WeekCalendar(2017,5),3);
        try {
            SoftwareHouse.getDatabase().getAssignmentEmployeeList("CBG").get(0).changeRegistration(day2, 300);
        } catch (TooManyHoursException e){
            assertEquals("You have registered too many hours today", e.getMessage());
        }

        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID).size(),2);
        assertEquals(SoftwareHouse.getEmployees().get(0).getBookedHours(week1,1),2);
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week1,1),78);
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week2,1),80);
        assertEquals(SoftwareHouse.getProjects().get(1).getAssignmentList().get(0).getBookedTime(),2);

    }
    @Test
    public void testManTwoWeekAssignment() throws Exception {
        System SoftwareHouse = new System();
        // Adds an employee
        String ID = "CBG";
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
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(1);
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
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week1, 1), 80);
        assertEquals(SoftwareHouse.getCurrentEmployee().getAvailableHours(week2,1),80);
        currentAssignment.setBudgetedTime(82);
        currentAssignment.manAssignment(SoftwareHouse.getEmployees().get(0), week1, 2, 82);
        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID).size(), 2);
        assertEquals(SoftwareHouse.getEmployees().get(0).getAvailableHours(week1, 1), 0);
        assertEquals(SoftwareHouse.getEmployees().get(0).getBookedHours(week1, 1), 80);
        assertEquals(SoftwareHouse.getEmployees().get(0).getAvailableHours(week2, 1), 78);

        assertEquals(SoftwareHouse.getEmployees().get(0).getBookedHours(week2,1),2);
        assertEquals(SoftwareHouse.getProjects().get(1).getAssignmentList().get(0).getBookedTime(),82);
    }

    @Test
    public void manTwoPeopleToAssignment() throws Exception{
        System SoftwareHouse = new System();
        // Adds an employee
        String ID = "CBG";
        SoftwareHouse.createEmployee(ID);
        Employee CBG= SoftwareHouse.getEmployees().get(0);
        assertEquals(SoftwareHouse.getEmployees().size(), 1);

        // Adds another employee
        String ID2 = "SDN";
        SoftwareHouse.createEmployee(ID2);
        Employee SDN = SoftwareHouse.getEmployees().get(1);
        assertEquals(SoftwareHouse.getEmployees().size(),2);

        // Adds a project
        SoftwareHouse.createProject("test");

        // Login as employee
        SoftwareHouse.logIn(ID);
        assertEquals(SoftwareHouse.getCurrentEmployee().getEmployeeID(), ID);
        assertEquals(SoftwareHouse.getCurrentEmployee(), SoftwareHouse.getEmployees().get(0));

        // Become projectLeader
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 0);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(1);
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 1);

        // Create an assignment
        Project currentProject = SoftwareHouse.getCurrentEmployee().getProjectLeaderList().get(0);
        currentProject.createAssignment("test");
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("test").getAssignmentList().size(), 1);
        Assignment currentAssignment = currentProject.getAssignmentByName("test");

        // Set budgettet time
        currentAssignment.setBudgetedTime(120);

        // Create WeekCalendar
        WeekCalendar week1 = new WeekCalendar(2017, 1);
        WeekCalendar week2 = new WeekCalendar(2017, 2);

        // ManAssignment
        currentAssignment.manAssignment(CBG, week1,1,20);
        currentAssignment.manAssignment(SDN,week1,2,100);

        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID).size(), 2);
        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeList(ID2).size(), 2);

        assertEquals(CBG.getAvailableHours(week1,1),60);
        assertEquals(SDN.getAvailableHours(week1,2),60);
        assertEquals(SDN.getAvailableHours(week1,1),0);
        assertEquals(SDN.getAvailableHours(week2,1),60);

        assertEquals(SoftwareHouse.getProjects().get(1).getAssignmentList().get(0).getBookedTime(),120);
        assertEquals(currentAssignment.getBudgetedTime(),120);
    }
}
