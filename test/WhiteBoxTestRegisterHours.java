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
    This test tests the method registerTime with the property: "Employee not logged in"

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
    Log off

    Step 7:
    Register time
     */

    @Test public void testRegisterTimeEmployeeNotLoggedIn() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01="Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject=SoftwareHouse.getProjects().get(0);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());

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
        SoftwareHouse.logOff();

        // Step 7
        WeekCalendar week1 = new WeekCalendar(2017,1);
        DayCalendar day1 = new DayCalendar(week1,1);
        try{
            SoftwareHouse.registerTime(day1, 8, 0);
        } catch (OperationNotAllowedException e){
            assertEquals("LogIn to register time", e.getMessage());
        }
    }

    /*
    Test 2
    Input data set W.2
    This test tests the method registerTime with the properties: "Employee logged in" and "Employee not manned to assigment"
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
    Register time
     */

    @Test
    public void testRegisterTimeEmployeeNotMannedToAssignment() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01="Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject=SoftwareHouse.getProjects().get(0);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());

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
        DayCalendar day1 = new DayCalendar(week1,1);
        assertEquals(0,SoftwareHouse.getCurrentEmployee().getRegisteredHalfHours(day1));
        try{
            SoftwareHouse.registerTime(day1, 8, 0);
        } catch (OperationNotAllowedException e){
            assertEquals("You are not manned to an assignment with the given ID", e.getMessage());
        }
        assertEquals(0,SoftwareHouse.getCurrentEmployee().getRegisteredHalfHours(day1));
    }

    /*
    Test 3
    Input dataset W.3
    This test tests the method registerTime with the properties: "Employee logged in", "Employee manned to the given
    assignment" and "Employee has already registered to many hours"
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
    Register 9
     */

    @Test
    public void testRegisterTimeMannedToAssignmentTooManyRegistreredHours() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01="Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject=SoftwareHouse.getProjects().get(0);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());

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
        assertEquals(0,currentEmployee.getAssignmentEmployeeList().size());
        currentAssignment.manAssignment(currentEmployee,week1,1,20);
        assertEquals(1,currentEmployee.getAssignmentEmployeeList().size());

        // Step 7
        DayCalendar day1 = new DayCalendar(week1,1);
        try{
            SoftwareHouse.registerTime(day1,18,0);
        } catch (TooManyHoursException e){
            assertEquals("You have registered too many hours today", e.getMessage());
        }
    }

    /*
    Test 4
    Input data set W.4
    This test tests the method registerTime with the properties: "Employee logged in" and "Employee manned to
    assignment", "Employee has not registered to many hours" and "Employee has not registered anything else"
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
    Register 7 hours to the assignment
     */

    @Test
    public void testRegisterTimeLessOrAllowedTimeFirstRegistration() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01="Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject=SoftwareHouse.getProjects().get(0);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());

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
        assertEquals(0,currentEmployee.getAssignmentEmployeeList().size());
        currentAssignment.manAssignment(currentEmployee,week1,1,20);
        assertEquals(1,currentEmployee.getAssignmentEmployeeList().size());

        // Step 7
        DayCalendar day1 = new DayCalendar(week1,1);
        SoftwareHouse.registerTime(day1,14,0);
        assertEquals(14,currentEmployee.getRegisteredHalfHours(day1));
    }

    /*
    Test 5
    Data input set 5
    This test tests the method registerTime with the properties: "Employee logged in" and "Employee manned to
    assignment", "Employee has not registered to many hours", "Employee has registered time once before" and "Employee
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
    Register 4 hours to the assignment in a given day

    Step 8:
    Register 4 hours to the assignment in the same day
     */

    @Test
    public void testRegisterTimeRegisterTwiceInSameDay() throws Exception{
        // Step 1

        WeekCalendar week1= new WeekCalendar(2017,1);
        DayCalendar dayCalendar1= new DayCalendar(week1, 1);
        DayCalendar dayCalenadr2 = new DayCalendar(week1,1);
        assertEquals(dayCalenadr2,dayCalendar1);

        /*System SoftwareHouse = new System();

        // Step 2
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfEmployees());
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfEmployees());

        // Step 3
        assertEquals(0,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID01="Project01";
        SoftwareHouse.createProject(PID01);
        Project currentProject=SoftwareHouse.getProjects().get(0);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());

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
        WeekCalendar week2 = new WeekCalendar(2018,2);
        assertEquals(0,currentEmployee.getAssignmentEmployeeList().size());
        currentAssignment.manAssignment(currentEmployee,week1,1,80);
        assertEquals(1,currentEmployee.getAssignmentEmployeeList().size());

        // Step 7
        DayCalendar day1 = new DayCalendar(week1,1);
        //SoftwareHouse.registerTime(day1,8,0);
        assertEquals(8,currentEmployee.getRegisteredHalfHours(day1));
        assertEquals(1,SoftwareHouse.getCurrentEmployee().getAssignmentEmployeeList().get(0).getBookedWeeks().size());
        // Step 8
        DayCalendar day2 = new DayCalendar(week2,2);

        DayCalendar day3 = new DayCalendar(week1,3);
        SoftwareHouse.registerTime(day3,8,0);
        assertEquals(8,currentEmployee.getRegisteredHalfHours(day3));
        */
    }

    /*
    Test 6
    Data input set W.6
    This test tests the method registerTime with the properties: "Employee logged in" and "Employee manned to
    assignment", "Employee has not registered to many hours", "Employee has registered time once before" and "Employee
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
    Register 4 hours to the assignment in another day

    Step 9:
    Register 4 hours to the assignment in a third day
     */






}
