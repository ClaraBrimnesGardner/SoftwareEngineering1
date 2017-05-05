/**
 * Created by sarad on 01-05-2017.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestSeekAssistance {

    /*
    Tests that the method seekAssistance adds an AssignmentEmployee
     */
    @Test
    public void testSeekAssistenceFromCoworker() throws Exception {
        // Creates a system
        System SoftwareHouse = new System();

        // Adds two employees
        String ID01="Employee01";
        SoftwareHouse.createEmployee(ID01);
        Employee Employee1 = SoftwareHouse.getEmployees().get(0);
        String ID02="Employee02";
        SoftwareHouse.createEmployee(ID02);
        Employee Employee2 = SoftwareHouse.getEmployees().get(1);


        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        Project currentProject = SoftwareHouse.getProjects().get(0);

        // Become projectLeader
        SoftwareHouse.logIn(ID01);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject.getProjectID());

        // Add an assignment
        String assignmentID="Assignment1";
        currentProject.createAssignment(assignmentID);
        Assignment currentAssignment = currentProject.getAssignmentByName(assignmentID);

        // Mans the assignment
        SoftwareHouse.seekAssistance("Employee02", "Assignment1", 2017, 4, 6);

        // Test that the booking is created
        SoftwareHouse.logIn(ID02);
        assertEquals(Employee2.getAssignmentEmployeeList().size(),1);
        // Test  that the taskID's are the same
        assertEquals(Employee2.getAssignmentEmployeeList().get(Employee2.getAssignmentEmployeeList().size()-1).taskID,SoftwareHouse.getDatabase().assignmentEmployeeList.get(0).taskID);
        // Test that the employeeID's are different (to make sure that it's not just a copy of the other assignment)
        assertEquals(Employee2.getAssignmentEmployeeList().get(Employee2.getAssignmentEmployeeList().size()-1).employee.employeeID,SoftwareHouse.getDatabase().assignmentEmployeeList.get(0).employee.employeeID);
    }

    /*
    Tests Alternative scenario 1: coworker does not exist
     */
    @Test
    public void testSeekAssistenceFromCoworkerA1() throws Exception {

        // Creates a system
        System SoftwareHouse = new System();

        // Adds an employee
        String ID01="Employee01";
        SoftwareHouse.createEmployee(ID01);
        Employee Employee1 = SoftwareHouse.getEmployees().get(0);


        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        Project currentProject = SoftwareHouse.getProjects().get(0);

        // Become projectLeader
        SoftwareHouse.logIn(ID01);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject.getProjectID());

        // Add an assignment
        String assignmentID="Assignment1";
        currentProject.createAssignment(assignmentID);
        Assignment currentAssignment = currentProject.getAssignmentByName(assignmentID);

        // Try to man the assignment
        try{
            SoftwareHouse.seekAssistance("Employee02", "Assignment1", 2017, 4, 6);
        } catch(WrongInputException e){
            assertEquals("Wrong employee name", e.getMessage());

        }
    }

    /*
    Tests Alternative scenario 2: coworker is not available
     */
    @Test
    public void testSeekAssistenceFromCoworkerA2() throws Exception {

        // Creates a system
        System SoftwareHouse = new System();

        // Adds two employees
        String ID01="Employee01";
        SoftwareHouse.createEmployee(ID01);
        Employee employee1 = SoftwareHouse.getEmployees().get(0);String ID02="Employee02";
        SoftwareHouse.createEmployee(ID02);
        Employee employee2 = SoftwareHouse.getEmployees().get(1);

        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        Project currentProject = SoftwareHouse.getProjects().get(0);

        // Become projectLeader
        SoftwareHouse.logIn(ID01);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject.getProjectID());

        // Add an assignment
        String assignmentID="Assignment1";
        currentProject.createAssignment(assignmentID);
        Assignment assignment1 = currentProject.getAssignmentByName(assignmentID);

        // Adds a weekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,4);

        // Man the assignment
        assignment1.manAssignment(employee2,week1,1,78);
        // Test that employee2 isn't available for 4 hours
        assertFalse(employee2.isAvailable(week1, 1,8));

        // Try to man the assignment
        try{
            SoftwareHouse.seekAssistance("Employee02", "Assignment1", 2017, 4, 8);
        } catch(WrongInputException e){
            assertEquals("Employee is not available", e.getMessage());

        }
    }
}
