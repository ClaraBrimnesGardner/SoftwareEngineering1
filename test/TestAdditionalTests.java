import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sarad on 05-05-2017.
 */
public class TestAdditionalTests {
    /*
    Additional tests in Database
     */
    @Test
    public void testAdditionalTestDatabase() throws Exception {
        // Creates a system
        System SoftwareHouse = new System();

        // Adds two employees
        String ID01 = "Employee01";
        SoftwareHouse.createEmployee(ID01);
        Employee Employee1 = SoftwareHouse.getEmployees().get(0);

        // Test last return statement in getProject in Datebase
        assertNull(SoftwareHouse.getDatabase().getProject(1));

        // Test last return statement in getAssignment in Database
        assertNull(SoftwareHouse.getDatabase().getAssignment("assingment"));

        // Adds a project and an assignment
        String projectID = "Project";
        SoftwareHouse.createProject(projectID);
        Project currentProject = SoftwareHouse.getProjects().get(0);
        String assignmentID01 = "Assignment1";
        currentProject.createAssignment(assignmentID01);
        Assignment assignment1 = currentProject.getAssignmentByName(assignmentID01);
        WeekBooking week1 = new WeekBooking(new WeekCalendar(2017,8),20);
        // Test last return statement in createBooking in Database
        //assertFalse(SoftwareHouse.getDatabase().createBooking(Employee1,assignment1,week1));

        // Test last return statement in getAvailableProjects in Database
        SoftwareHouse.getDatabase().getAvailableProjects();

    }

    /*
    Additional tests in Employee
     */
    @Test
    public void testAdditionalTestEmployee() throws Exception {
        // Creates a system
        System SoftwareHouse = new System();

        // Test equals i DayCalender
        WeekCalendar week2 = new WeekCalendar(2017,43);
        DayCalendar day2 = new DayCalendar(week2,2);
        assertFalse(day2.equals(week2));

        // Adds two employees
        String ID01 = "Employee01";
        SoftwareHouse.createEmployee(ID01);
        Employee Employee1 = SoftwareHouse.getEmployees().get(0);

        // Adds a project and an assignment
        String projectID = "Project";
        SoftwareHouse.createProject(projectID);
        Project currentProject = SoftwareHouse.getProjects().get(0);
        String assignmentID01 = "Assignment1";
        currentProject.createAssignment(assignmentID01);
        Assignment assignment1 = currentProject.getAssignmentByName(assignmentID01);

        // Test last return statement in getProjectbyName in Employee
        String fakeProject = "ProjectX";
        Employee1.becomeProjectLeader(currentProject.getProjectID());
        assertNull(Employee1.getProjectByName(fakeProject));

        // Man assignment to create assignmentEmployee
        SoftwareHouse.getDatabase().getAssignment(assignmentID01).manAssignment(Employee1,week2,2,170);
        // Test getAssignmentEmployeeByID in Employee
        //assertNull(Employee1.getAssignmentEmployeeByID(1));
        //assertEquals(Employee1.getAssignmentEmployeeByID(0).getTaskID(),0);
    }
}
