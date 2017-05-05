import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by clarabrimnesgardner on 05/05/2017.
 */
public class TestBlackBoxUseCase4 {
    /*
    Black box tests for the revised use case 4 which concentrates the methods getAvailableEmployees and manAssignment
     */

    /*
    Test 1
    Tests the main scenario for use case number 4: The project leader chooses an assignment in a project he is the lead-
    er of, gets a lists of available employees and mans one of them to the assignment.

    Step 1:
    Creates a system

    Step 2:
    Adds an employee

    Step 3:
    Adds a project

    Step 4:
    Log in and Become project leader

    Step 5:
    Add an assignment to the project

    Step 6:
    Get a list of available employees for a period

    Step 7:
    Man one of the employees from the list to the assigment
     */


    @Test
    public void testUseCase4MainScenario() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        assertEquals(0, SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1, SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(1, SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01 = "Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject = SoftwareHouse.getProjects().get(1);
        assertEquals(2, SoftwareHouse.getDatabase().getNumberOfProjects());

        // Step 4
        SoftwareHouse.logIn(EID01);
        assertEquals("CBG", SoftwareHouse.getCurrentEmployee().getEmployeeID());
        Employee currentEmployee = SoftwareHouse.getCurrentEmployee();
        assertEquals(0, currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(currentProject.getProjectID());
        assertEquals(1, currentEmployee.getProjectLeaderList().size());

        // Step 5
        String AID01 = "Assignment01";
        assertEquals(0, currentProject.getAssignmentList().size());
        currentProject.createAssignment(AID01);
        assertEquals(1, currentProject.getAssignmentList().size());
        Assignment currentAssignment = currentProject.getAssignmentByName(AID01);

        // Step 6
        WeekCalendar week1=new WeekCalendar(2017,1);
        List<Employee> availableEmployees = SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,20);
        assertEquals(1,availableEmployees.size());
        Employee availableEmployee = availableEmployees.get(0);

        // Step 7
        currentAssignment.setBudgetedTime(20);
        currentAssignment.manAssignment(availableEmployee, week1, 1, 20);
        assertEquals(60,availableEmployee.getAvailableHours(week1,1));
        assertEquals(20,availableEmployee.getBookedHours(week1,1));
    }

    /*
    Test 2
    Tests alternative scenario 2 in use case number 4: The project leader types a name for an activity, which doesn't
    exist.

    Step 1:
    Creates a system

    Step 2:
    Adds an employee

    Step 3:
    Adds a project

    Step 4:
    Tries to access a project which does not exist
    */
    @Test
    public void testUseCase4AlternativeScenario1() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        assertEquals(0, SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1, SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(1, SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01 = "Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject = SoftwareHouse.getProjects().get(1);
        assertEquals(2, SoftwareHouse.getDatabase().getNumberOfProjects());

        // Step 4
        String AID01 = "Assignment01";
        try {
            Assignment currentAssignment = currentProject.getAssignmentByName(AID01);
        } catch (WrongInputException e){
            assertEquals("Assignment doesn't exist", e.getMessage());
        }
    }

    /*
    Test 3
    Tests alternative scenario 2 in use case 4: The project leader tries to man an employee which is not available
    Step 1:
    Creates a system

    Step 2:
    Adds an employee

    Step 3:
    Adds a project

    Step 4:
    Log in and Become project leader

    Step 5:
    Add an assignment to the project

    Step 6:
    Get a list of available employees for a period

    Step 7:
    Man one of the employees from the list to the assigment for 40 hours

    Step 8:
    Man same employees 50 hours more

     */
    @Test
    public void testUseCase4AlternativeScenario2() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        assertEquals(0, SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1, SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(1, SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01 = "Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject = SoftwareHouse.getProjects().get(1);
        assertEquals(2, SoftwareHouse.getDatabase().getNumberOfProjects());

        // Step 4
        SoftwareHouse.logIn(EID01);
        assertEquals("CBG", SoftwareHouse.getCurrentEmployee().getEmployeeID());
        Employee currentEmployee = SoftwareHouse.getCurrentEmployee();
        assertEquals(0, currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(currentProject.getProjectID());
        assertEquals(1, currentEmployee.getProjectLeaderList().size());

        // Step 5
        String AID01 = "Assignment01";
        assertEquals(0, currentProject.getAssignmentList().size());
        currentProject.createAssignment(AID01);
        assertEquals(1, currentProject.getAssignmentList().size());
        Assignment currentAssignment = currentProject.getAssignmentByName(AID01);

        // Step 6
        WeekCalendar week1=new WeekCalendar(2017,1);
        List<Employee> availableEmployees = SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,40);
        assertEquals(1,availableEmployees.size());
        Employee availableEmployee = availableEmployees.get(0);

        // Step 7
        currentAssignment.setBudgetedTime(90);
        currentAssignment.manAssignment(availableEmployee, week1, 1, 40);
        assertEquals(40,availableEmployee.getAvailableHours(week1,1));
        assertEquals(40,availableEmployee.getBookedHours(week1,1));

        // Step 8
        currentAssignment.manAssignment(availableEmployee, week1, 1, 50);
        assertEquals(0,availableEmployee.getAvailableHours(week1,1));
        assertEquals(80,availableEmployee.getBookedHours(week1,1));
    }


}
