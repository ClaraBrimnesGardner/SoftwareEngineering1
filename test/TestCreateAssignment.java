/**
 * Created by clarabrimnesgardner on 17/04/2017.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestCreateAssignment {
    /*
    Test that createAssignment creates and assignment with
     */
    @Test
    public void testCreateAssignment() throws WrongInputException {
        // Creates a system
        System SoftwareHouse = new System();
        String ID = "Employee1";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(), 1);

        // Adds a project
        SoftwareHouse.createProject("Project1");
        // Login as employee
        SoftwareHouse.logIn(ID);
        assertEquals(SoftwareHouse.getCurrentEmployee().getEmployeeID(), ID);
        assertEquals(SoftwareHouse.getCurrentEmployee(), SoftwareHouse.getEmployees().get(0));

        // Become projectLeader

        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 0);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(0);


        // Add an activity
        Project currentProject = SoftwareHouse.getCurrentEmployee().getProjectLeaderList().get(0);
        currentProject.createAssignment("test");

        // Checks that the currentEmployee now has a project with an assignment
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("Project1").getAssignmentList().size(), 1);
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("Project1").getAssignmentByName("test").getName(), "test");
    }

    /*
    Tests that two assignments with the same name cannot be created
     */
    @ Test
    public void testCreateAlreadyExistingProject() throws WrongInputException{
        // Creates a system
        System SoftwareHouse = new System();
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

        //assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 0);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(0);


        // Add an activity
        Project currentProject = SoftwareHouse.getCurrentEmployee().getProjectLeaderList().get(0);
        currentProject.createAssignment("test");

        // Checks that the currentEmployee now has a project with an assignment
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("test").getAssignmentList().size(), 1);

        // Add another activity

        try {
            currentProject.createAssignment("test");
        } catch (WrongInputException e){
            assertEquals("Projectname is used", e.getMessage());
        }
        assertEquals(currentProject.getAssignmentList().size(),1);

    }

    @Test
    public void testTwoProjectAndAssignments() throws WrongInputException{
        // Creates a system
        System SoftwareHouse = new System();
        String ID = "Employee1";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(), 1);

        // Adds a project
        SoftwareHouse.createProject("Project1");
        // Login as employee
        SoftwareHouse.logIn(ID);
        assertEquals(SoftwareHouse.getCurrentEmployee().getEmployeeID(), ID);
        assertEquals(SoftwareHouse.getCurrentEmployee(), SoftwareHouse.getEmployees().get(0));

        // Become projectLeader

        //assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 0);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(0);
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 1);


        // Add an activity
        Project currentProject = SoftwareHouse.getCurrentEmployee().getProjectLeaderList().get(0);
        currentProject.createAssignment("test");

        // Checks that the currentEmployee now has a project with an assignment
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("Project1").getAssignmentList().size(), 1);

        // Adds another project
        // Adds a project
        SoftwareHouse.createProject("Project2");
        // Become projectLeader

        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectLeaderList().size(), 1);
        //SoftwareHouse.getCurrentEmployee().becomeProjectLeader(1);

        /*
        // Add an activity
        currentProject = SoftwareHouse.getCurrentEmployee().getProjectByName("Project2");
        currentProject.createAssignment("test1");
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("Project2").getAssignmentList().size(), 1);
        assertEquals(SoftwareHouse.getCurrentEmployee().getProjectByName("Project1").getAssignmentList().size(), 1);
        */
    }
}
