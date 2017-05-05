import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by clarabrimnesgardner on 01/05/2017.
 */
public class WhiteBoxTestRegisterHours {
    /*
    White Box tests to test the function register hours
     */
    /*
    Test 1
    Input data set W.1
    This test tests the method registerTime with the properties: "Employee has already registered to many hours"
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

    /*
    Test 2
    Input data set W.2
    This test tests the method registerTime with the properties: "Employee has not registered too many hours" and
    "Employee is not booked to the assignment in this week"
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
    public void testRegisterTimeNotBookedToAssignmentInCurrentWeek() throws Exception{
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



        WeekCalendar week2 = new WeekCalendar(2017,2);
        DayCalendar day1 = new DayCalendar(week2,1);
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01,currentEmployee);
        try{
            currentAssignmentEmployee.registerTime(day1,14);
        } catch (OperationNotAllowedException e){
            assertEquals("You are not booked to this assignment in this week",e.getMessage());
        }
        assertEquals(0,currentEmployee.getRegisteredHalfHours(day1));
    }

    /*
    Test 3
    Data input set W.3
    This test tests the method registerTime with the properties: "Employee has not registered too many hours",
    "Employee is booked to the assignment in the current week" and "Employee has not registered anything yet"
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
    public void testRegisterTimeFirstTime() throws Exception{
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
        currentAssignment.manAssignment(currentEmployee,week1,1,80);
        assertEquals(2,currentEmployee.getAssignmentEmployeeList().size());
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01,currentEmployee);
        assertEquals(1,SoftwareHouse.getCurrentEmployee().getAssignmentEmployeeList().get(1).getBookedWeeks().size());

        // Step 7
        DayCalendar day1 = new DayCalendar(week1,1);
        currentAssignmentEmployee.registerTime(day1,8);
        assertEquals(8,currentEmployee.getRegisteredHalfHours(day1));
    }

    /*
    Test 4
    Data input set W.4
    This test tests the method registerTime with the properties: "Employee has not registered too many hours",
    "Employee is booked to chosen assignment in chosen week", "Employee has performed one registration before" and
    "Employee has registered time the same day"
    has registered time the same day before"
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
    Register 4 hours to the assignment in one day

    Step 8:
    Register 4 hours to the assignment in the same day
     */

    @Test
    public void testRegisterTimeSecondTimeInDay() throws Exception{
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
        currentAssignment.manAssignment(currentEmployee,week1,1,80);
        assertEquals(2,currentEmployee.getAssignmentEmployeeList().size());
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01,currentEmployee);
        assertEquals(1,SoftwareHouse.getCurrentEmployee().getAssignmentEmployeeList().get(1).getBookedWeeks().size());

        // Step 7
        DayCalendar day1 = new DayCalendar(week1,1);
        currentAssignmentEmployee.registerTime(day1,8);
        assertEquals(8,currentEmployee.getRegisteredHalfHours(day1));

        // Step 8
        currentAssignmentEmployee.registerTime(day1, 8);
        assertEquals(16,currentEmployee.getRegisteredHalfHours(day1));

    }

    /*
    Test 5
    Data input set W.5
    This test tests the method registerTime with the properties: "Employee has not registered too many hours",
    "Employee is booked to chosen assignment in chosen week", "Employee has performed multiple registrations" and
    "Employee has not performed any registrations the chosen day"
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
    Register 4 hours to the assignment in one day

    Step 8:
    Register 4 hours to the assignment in another day

    Step 9:
    Register 4 hours to the assignment in a third day
     */

    @Test
    public void testRegisterTimeMultipleRegistrationsPerformed() throws Exception{
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
        currentAssignment.manAssignment(currentEmployee,week1,1,80);
        assertEquals(2,currentEmployee.getAssignmentEmployeeList().size());
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01,currentEmployee);
        assertEquals(1,SoftwareHouse.getCurrentEmployee().getAssignmentEmployeeList().get(1).getBookedWeeks().size());

        // Step 7
        DayCalendar day1 = new DayCalendar(week1,1);
        currentAssignmentEmployee.registerTime(day1,8);
        assertEquals(8,currentEmployee.getRegisteredHalfHours(day1));

        // Step 8
        DayCalendar day2 = new DayCalendar(week1,2);
        currentAssignmentEmployee.registerTime(day2, 8);
        assertEquals(8,currentEmployee.getRegisteredHalfHours(day1));

        // Step 9
        DayCalendar day3 = new DayCalendar(week1, 3);
        currentAssignmentEmployee.registerTime(day3, 8);
        assertEquals(8,currentEmployee.getRegisteredHalfHours(day1));

    }





}
