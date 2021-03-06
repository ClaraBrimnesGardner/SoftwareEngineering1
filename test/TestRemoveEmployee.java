import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sarad on 04-05-2017.
 */
public class TestRemoveEmployee {
    /*
   Test that deleteEmployee deletes an employee
    */
    @Test
    public void testDeleteEmployee() throws Exception {
        // Creates a system
        System SoftwareHouse = new System();
        // create two employees
        String ID1 = "CBG";
        SoftwareHouse.createEmployee(ID1);
        String ID2 = "SDN";
        SoftwareHouse.createEmployee(ID2);
        // check size of employee list
        assertEquals(SoftwareHouse.getEmployees().size(), 2);

        try{
            SoftwareHouse.logIn("Employee3");
        } catch(WrongInputException e){
            assertEquals("Employee doesn't exist", e.getMessage());
        }
        SoftwareHouse.logIn("CBG");

        // try to remove logged in employee
        try{
            SoftwareHouse.removeEmployee("CBG");
        } catch(WrongInputException e){
            assertEquals("You can't delete yourself", e.getMessage());
        }
        // remove SDN
        SoftwareHouse.removeEmployee("SDN");
        // check size of employee list
        assertEquals(SoftwareHouse.getEmployees().size(), 1);
    }

    /*
    Test that deleteProject deletes a project
   */
    @Test
    public void testDeleteProject() throws Exception {
        // Creates a system
        System SoftwareHouse = new System();

        // Adds two employees
        String ID01="CBG";
        SoftwareHouse.createEmployee(ID01);
        Employee CBG = SoftwareHouse.getEmployees().get(0);
        String ID02="SDN";
        SoftwareHouse.createEmployee(ID02);
        Employee SDN = SoftwareHouse.getEmployees().get(1);

        // Adds a project
        String projectID="Project";
        SoftwareHouse.createProject(projectID);
        Project currentProject = SoftwareHouse.getProjects().get(1);
        assertEquals(SoftwareHouse.getDatabase().getProjectList().size(),2);

        // Become projectLeader
        SoftwareHouse.logIn(ID01);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject.getProjectID());

        // Try to remove project without being project leader
        SoftwareHouse.logIn(ID02);
        try{
            SoftwareHouse.removeProject(currentProject.getProjectID());
        } catch(WrongInputException e) {
            assertEquals("You are not project leader of this project", e.getMessage());
        }

        // Remove project as project leader
        SoftwareHouse.logIn(ID01);
        SoftwareHouse.removeProject(currentProject.getProjectID());
        assertEquals(SoftwareHouse.getDatabase().getProjectList().size(),1);

        // Adds project again
        String projectID01="Project";
        SoftwareHouse.createProject(projectID01);
        Project currentProject01 = SoftwareHouse.getProjects().get(1);
        SoftwareHouse.getCurrentEmployee().becomeProjectLeader(currentProject01.getProjectID());
        // Add two assignments
        String assignmentID01 = "Assignment1";
        currentProject01.createAssignment(assignmentID01);
        Assignment assignment1 = currentProject01.getAssignmentByName(assignmentID01);
        String assignmentID02 = "Assignment2";
        currentProject01.createAssignment(assignmentID02);
        Assignment assignment2 = currentProject01.getAssignmentByName(assignmentID02);
        assertEquals(SoftwareHouse.getDatabase().getAssignmentList().size(),5);
        // Man assignment to create an AssignmentEmployee
        WeekCalendar week1 = new WeekCalendar(2017,9);
        SoftwareHouse.getDatabase().getAssignment(assignmentID02).setBudgetedTime(170);
        SoftwareHouse.getDatabase().getAssignment(assignmentID02).manAssignment(CBG,week1,2,170);
        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeListWork(ID01).size(),1);
        assertEquals(SoftwareHouse.getDatabase().getAssignmentEmployeeListWork(ID01).get(0).getTaskID(),2);
        // Remove assignment1
        SoftwareHouse.removeAssignment("Assignment1");
        assertEquals(SoftwareHouse.getDatabase().getAssignmentList().size(),4);
        assertEquals(SoftwareHouse.getDatabase().getProjectList().size(),2);
        // Remove project and thereby assignment2 og the assignmentEmployee
        SoftwareHouse.removeProject(currentProject01.getProjectID());
        assertEquals(SoftwareHouse.getDatabase().getProjectList().size(),1);
    }
}
