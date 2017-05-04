import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by sarad on 04-05-2017.
 */
public class TestRemoveEmployee {
    /*
   Test that deleteEmployee deletes an employee
    */
    @Test
    public void testDeleteEmployee() throws WrongInputException {
        // Creates a system
        System SoftwareHouse = new System();
        // create two employees
        String ID1 = "Employee1";
        SoftwareHouse.createEmployee(ID1);
        String ID2 = "Employee2";
        SoftwareHouse.createEmployee(ID2);
        // check size of employee list
        assertEquals(SoftwareHouse.getEmployees().size(), 2);

        try{
            SoftwareHouse.logIn("Employee3");
        } catch(WrongInputException e){
            assertEquals("Employee doesn't exist", e.getMessage());

        }
        SoftwareHouse.logIn("Employee1");

        // try to remove logged in employee
        try{
            SoftwareHouse.removeEmployee("Employee1");
        } catch(WrongInputException e){
            assertEquals("You can't delete yourself", e.getMessage());

        }
        // remove employee2
        SoftwareHouse.removeEmployee("Employee2");
        // check size of employee list
        assertEquals(SoftwareHouse.getEmployees().size(), 1);
    }

    /*
    Test that deleteProject deletes a project
   */
    @Test
    public void testDeleteProject() throws WrongInputException {
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
        SoftwareHouse.removeProject(currentProject.projectID);
        /*try{

        } catch(WrongInputException e){
            assertEquals("You can't delete yourself", e.getMessage());

        }

        // Add an assignment
        String assignmentID="Assignment1";
        currentProject.createAssignment(assignmentID);
        Assignment currentAssignment = currentProject.getAssignmentByName(assignmentID);*/
    }
}
