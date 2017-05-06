import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by clarabrimnesgardner on 05/05/2017.
 */
public class WhiteBoxTestManAssignment {
    /*
    White Box tests to the function man assignment
     */

    /*
    Test 1
    Input data set W.1
    This test tests the method manAssignment with the properties: "Project leader tries to book less than zero hours"

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
    Try to book more than zero hours to the assignment
     */

    @Test
    public void testManAssignmentLessThanAllowedHours() throws Exception{
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
        try {
            currentAssignment.manAssignment(currentEmployee, week1, 1, -1);
        } catch (TooManyHoursException e){
            assertEquals("You can't book less than 0 hours", e.getMessage());
        }
        assertEquals(0,currentAssignment.getBookedTime());
    }

    /*
    Test 2
    Data input set W.2
    Test the method manAssignment with the properties: "Project books more than zero hours" and "Assignment doesn't
    have enough budgetted time"
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
    Try to man yourself to assignment
     */

    @Test
    public void testManAssignmentLessThanBudgetedTime() throws Exception{
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
        try {
            currentAssignment.manAssignment(currentEmployee, week1, 1, 20);
        } catch (TooManyHoursException e){
            assertEquals("The hours you want to book exceeds the budgetted time", e.getMessage());
        }
    }

    /*
    Test 3
    Data input set: W.3
    Tests the method manAssignment with the Properties: "Assignment has enough budgeted time" and "The project leader
    books zero hours"
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
    Man yourself for zero hours to the assignment

     */

    @Test
    public void manAssignmentZeroHours() throws Exception{
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
        currentAssignment.manAssignment(currentEmployee, week1, 1,0);
        assertEquals(0,currentAssignment.getBookedTime());
    }

    /*
    Test 4
    Data input set W.4
    Tests the method manAssignment with the properties: "Assignment has enough budgeted time", "The duration is one
    week" and "The project leader books less hours, than the employee has available in one week"

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
    Set budgetted time to 8 hours

    Step 7:
    Man yourself to assignment with 8 hours in one week
     */

    @Test
    public void testManAssignmentOneWeekLessThanAvaiableHours() throws Exception{
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
        assertEquals(0,currentAssignment.getBudgetedTime());
        currentAssignment.setBudgetedTime(8);
        assertEquals(8,currentAssignment.getBudgetedTime());

        // Step 7
        WeekCalendar week1 = new WeekCalendar(2017,1);
        assertEquals(1,currentEmployee.getAssignmentEmployeeList().size());
        currentAssignment.manAssignment(currentEmployee, week1, 1,8);
        assertEquals(8,currentAssignment.getBookedTime());
    }

    /*
    Test 5
    Input data set W.5
    Tests the method manAssignment with the properties: "Assignment has enough budgeted time", "Duration is more than
    one week", "Project leader books more time than the employee has available in one week"

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
    Set budgetted time to 8 hours

    Step 7:
    Man yourself to assignment with 120 in two weeks
     */

    @Test
    public void testManAssignmentMoreThanOneWeekM () throws Exception{
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
        assertEquals(0,currentAssignment.getBudgetedTime());
        currentAssignment.setBudgetedTime(120);
        assertEquals(120,currentAssignment.getBudgetedTime());

        // Step 7
        WeekCalendar week1 = new WeekCalendar(2017,1);
        assertEquals(1,currentEmployee.getAssignmentEmployeeList().size());
        currentAssignment.manAssignment(currentEmployee, week1, 2,120);
        assertEquals(120,currentAssignment.getBookedTime());
        assertEquals(80, currentEmployee.getBookedHours(week1, 1));
        assertEquals(40, currentEmployee.getBookedHours(week1.increaseWeek(1),1));

    }
}

