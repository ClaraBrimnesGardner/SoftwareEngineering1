import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sarad on 05-05-2017.
 */
public class TestAdditionalTests {
    /*
    Tests that the method getAvailableProjects in Database
     */
    @Test
    public void testSeekAssistenceFromCoworker() throws WrongInputException {
        // Creates a system
        System SoftwareHouse = new System();

        // Adds two employees
        String ID01 = "Employee01";
        SoftwareHouse.createEmployee(ID01);
        Employee Employee1 = SoftwareHouse.getEmployees().get(0);

        //
        assertNull(SoftwareHouse.getDatabase().getProject(1));
        assertNull(SoftwareHouse.getDatabase().getAssignment("assingment"));

        // Adds a project and an assignment
        String projectID = "Project";
        SoftwareHouse.createProject(projectID);
        Project currentProject = SoftwareHouse.getProjects().get(0);
        String assignmentID01 = "Assignment1";
        currentProject.createAssignment(assignmentID01);
        Assignment assignment1 = currentProject.getAssignmentByName(assignmentID01);
        WeekBooking week1 = new WeekBooking(new WeekCalendar(2017,8),20);
        //assertFalse(SoftwareHouse.getDatabase().createBooking(Employee1,assignment1,week1));

        SoftwareHouse.getDatabase().getAvailableProjects();
    }
}
