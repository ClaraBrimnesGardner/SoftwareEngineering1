import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        String ID01 = "CBG";
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

        // Adds two employees
        String ID01 = "CBG";
        SoftwareHouse.createEmployee(ID01);
        Employee Employee1 = SoftwareHouse.getEmployees().get(0);
        String ID02 = "SARA";
        SoftwareHouse.createEmployee(ID02);
        Employee Employee2 = SoftwareHouse.getEmployees().get(0);

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
        WeekCalendar week2 = new WeekCalendar(2017,43);
        SoftwareHouse.getDatabase().getAssignment(assignmentID01).setBudgetedTime(170);
        SoftwareHouse.getDatabase().getAssignment(assignmentID01).manAssignment(Employee1,week2,2,170);

        // Test getAssignmentEmployeeByID in Employee
        assertNull(Employee1.getAssignmentEmployeeByID(3));
        assertEquals(Employee1.getAssignmentEmployeeByID(0).getTaskID(),0);

        // Test bookVacation in Employee
        WeekCalendar week1 = new WeekCalendar(2017,2);
        Employee1.bookVacation(week1,1,2);

        // Test bookSeminar in Employee
        WeekCalendar week3 = new WeekCalendar(2017,3);
        Employee2.bookSeminar(week3,1,2);
    }

    /*
    Additional tests in Project
     */
    @Test
    public void testAdditionalTestProject() throws Exception {
        // Creates a system
        System SoftwareHouse = new System();

        // Adds two employees
        String ID01 = "CBG";
        SoftwareHouse.createEmployee(ID01);
        Employee Employee1 = SoftwareHouse.getEmployees().get(0);

        // Adds a project
        String projectID = "Project";
        SoftwareHouse.createProject(projectID);
        Project currentProject = SoftwareHouse.getProjects().get(0);

        // Tests getSystem and setSystem in Project
        System system = currentProject.getSystem();
        System newSystem = new System();
        currentProject.setSystem(newSystem);
    }

    /*
    Additional tests in Project
     */
    @Test
    public void testAdditionalTestSystem() throws Exception {
        // Creates a system
        System SoftwareHouse = new System();

        // Test getThisDay in System
        Calendar calendarTest = new GregorianCalendar();
        assertEquals(Calendar.DAY_OF_WEEK,SoftwareHouse.getThisDay().dayNumber);

        // Tests convertToHalfHours in System
        int hours = 4;
        assertEquals(SoftwareHouse.convertToHalfHours(hours),4*2);
    }

    /*
    Additional tests in WeekCalender
     */
    @Test
    public void testAdditionalTestWeekCalendar() throws Exception {
        WeekCalendar week1 = new WeekCalendar(2016,40);
        WeekCalendar week2 = new WeekCalendar(2017,2);

        // Tests weeksTo in WeekCalendar
        assertEquals(week1.weeksTo(week2),14);

        // Tests increadeWeek in WeekCalendar
        assertEquals(week1.increaseWeek(30).getWeekNumber(),18);

        // Tests after in WeekCalender
        assertTrue(week2.after(week1));

        // Test equals i DayCalender
        WeekCalendar week3 = new WeekCalendar(2017,43);
        DayCalendar day2 = new DayCalendar(week3,2);
        assertFalse(day2.equals(week3));
    }
}
