import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by clarabrimnesgardner on 05/05/2017.
 */
public class TestBlackBoxUseCase6 {
    /*
    Black box tests for the revised use case 6, which concerns the method register time.
     */

    /*
    Test 1
    Tests the main scenario for use case number 6
    Step 1:
    Create a system

    Step 2:
    Add an employee

    Step 3:
    Add a project

    Step 4:
    Log in and Become project leader

    Step 5:
    Add an assignment

    Step 6:
    Man yourself to assignment

    Step 7:
    Register 4 hours to the assignment in a given day

    */

    @Test
    public void testUseCase6MainScenario() throws Exception {
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
        WeekCalendar week1 = new WeekCalendar(2017, 1);
        assertEquals(1, currentEmployee.getAssignmentEmployeeList().size());
        currentAssignment.manAssignment(currentEmployee, week1, 1, 80);
        assertEquals(2, currentEmployee.getAssignmentEmployeeList().size());
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01, currentEmployee);
        assertEquals(1, SoftwareHouse.getCurrentEmployee().getAssignmentEmployeeList().get(1).getBookedWeeks().size());

        // Step 7
        DayCalendar day1 = new DayCalendar(week1, 1);
        currentAssignmentEmployee.registerTime(day1, 8);
        assertEquals(8, currentEmployee.getRegisteredHalfHours(day1));
    }
    /*
    Test 2
    Tests alternative scenario 1 for use case number 6: The user tries to register time to an assignment he is not
    booked to in the chosen week

    Step 1:
    Create a system

    Step 2:
    Add an employee

    Step 3:
    Add a project

    Step 4:
    Log in and Become project leader

    Step 5:
    Add an assignment

    Step 6:
    Man yourself to assignment in one week

    Step 7
    Register less than the allowed 8 hours to the assignment in another week
     */

    @Test
    public void testUseCase6Alternative1() throws Exception {
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
        WeekCalendar week1 = new WeekCalendar(2017, 1);
        assertEquals(1, currentEmployee.getAssignmentEmployeeList().size());
        currentAssignment.manAssignment(currentEmployee, week1, 1, 20);
        assertEquals(2, currentEmployee.getAssignmentEmployeeList().size());


        WeekCalendar week2 = new WeekCalendar(2017, 2);
        DayCalendar day1 = new DayCalendar(week2, 1);
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01, currentEmployee);
        try {
            currentAssignmentEmployee.registerTime(day1, 14);
        } catch (OperationNotAllowedException e) {
            assertEquals("You are not booked to this assignment in this week", e.getMessage());
        }
        assertEquals(0, currentEmployee.getRegisteredHalfHours(day1));
    }
    /*
    Test 3
    Tests alternative scenario 2 in use case 6: the employee tries to register too many hours in one day
    Step 1:
    Create a system

    Step 2:
    Add an employee

    Step 3:
    Add a project

    Step 4:
    Log in and Become project leader

    Step 5:
    Add an assignment

    Step 6:
    Register more than the allowed 8 hours
     */

    @Test
    public void testRegisterTimeMannedToAssignmentTooManyRegisteredHours() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01="Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject=SoftwareHouse.getProjects().get(1);
        assertEquals(2,SoftwareHouse.getDatabase().getNumberOfProjects());

        // Step 4
        SoftwareHouse.logIn(EID01);
        assertEquals("CBG",SoftwareHouse.getCurrentEmployee().getEmployeeID());
        Employee currentEmployee=SoftwareHouse.getCurrentEmployee();
        assertEquals(0,currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(currentProject.getProjectID());
        assertEquals(1,currentEmployee.getProjectLeaderList().size());

        // Step 5
        String AID01="Assignment01";
        assertEquals(0,currentProject.getAssignmentList().size());
        currentProject.createAssignment(AID01);
        assertEquals(1,currentProject.getAssignmentList().size());
        Assignment currentAssignment=currentProject.getAssignmentByName(AID01);

        // Step 6
        WeekCalendar week1 = new WeekCalendar(2017,1);
        assertEquals(1,currentEmployee.getAssignmentEmployeeList().size());
        currentAssignment.manAssignment(currentEmployee,week1,1,20);
        assertEquals(2,currentEmployee.getAssignmentEmployeeList().size());

        // Step 7
        DayCalendar day1 = new DayCalendar(week1,1);
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01,currentEmployee);
        try{
            currentAssignmentEmployee.registerTime(day1,18);
        } catch (TooManyHoursException e){
            assertEquals("You have registered too many hours today", e.getMessage());
        }
    }





}

