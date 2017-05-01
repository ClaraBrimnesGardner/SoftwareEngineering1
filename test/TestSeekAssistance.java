/**
 * Created by sarad on 01-05-2017.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSeekAssistance {

    /*
    Tests that the method seekAssistance adds an AssignmentEmployee
     */
    @Test
    public void testSeekAssistenceFromCoworker() throws WrongInputException {
        // Creates a system
        System SoftwareHouse = new System();

        // Adds an employee
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

        //checks that the booking is created.
        SoftwareHouse.logIn(ID02);
        assertEquals(Employee2.getAssignmentEmployeeList().size(),1);
    }

}
