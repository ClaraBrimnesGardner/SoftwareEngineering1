import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Created by clarabrimnesgardner on 30/04/2017.
 */
public class BlackBoxTestRegisterHours {
    /*
    Black Box tests to test the function register hours
     */

    /*
    Test 1:
    Register less than 8 hours in one day at one assignment.

    Step 1:
    Create a system

    Step 2:
    Add an employee

    Step 3:
    Add a project

    Step 4:
    Become Projectleader

    Step 5:
    Adds an assignment

    Step 6:
    Registers 4 hours to the assignment
     */

    @Test
    public void registerLessThanAllowedTimeOneDayOneProject()throws Exception{
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

        currentAssignment.manAssignment(currentEmployee, week1,1,20);

        DayCalendar day1 = new DayCalendar(week1,1);
        SoftwareHouse.registerTime(day1,8,0);
        assertEquals(8,SoftwareHouse.getCurrentEmployee().getRegisteredHalfHours(day1));
    }

     /*
    Test 2:
    Register 8 hours in one day at one assignment.

    Step 1:
    Create a system

    Step 2:
    Add an employee

    Step 3:
    Add a project

    Step 4:
    Become Projectleader

    Step 5:
    Adds an assignment

    Step 6:
    Registers 8 hours to the assignment
     */
    @Test
    public void registerAllowedTimeOneDayOneProject() throws Exception{
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

        currentAssignment.manAssignment(currentEmployee, week1,1,20);

        DayCalendar day1 = new DayCalendar(week1,1);
        SoftwareHouse.registerTime(day1,16,0);
        assertEquals(16,SoftwareHouse.getCurrentEmployee().getRegisteredHalfHours(day1));
    }

    /*
   Test 3:
   Register 8 hours in one day at one assignment.

   Step 1:
   Create a system

   Step 2:
   Add an employee

   Step 3:
   Add a project

   Step 4:
   Become Projectleader

   Step 5:
   Adds an assignment

   Step 6:
   Registers 12 hours to the assignment
    */
    @Test
    public void registerMoreThanAllowedTimeOneDayOneProject() throws Exception{
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

        currentAssignment.manAssignment(currentEmployee, week1,1,25);

        DayCalendar day1 = new DayCalendar(week1,1);
        try {
            SoftwareHouse.registerTime(day1, 24, 0);
        } catch (TooManyHoursException e){
            assertEquals(e.getMessage(),"You have already registered too many hours today");
        }
        assertEquals(0,SoftwareHouse.getCurrentEmployee().getRegisteredHalfHours(day1));
    }
    /*
   Test 4:
   Register less than 8 hours in one day at two different assignments.

   Step 1:
   Create a system

   Step 2:
   Add an employee

   Step 3:
   Add two projects

   Step 4:
   Become Projectleader

   Step 5:
   Adds assignments

   Step 6:
   Registers 2 hours to each project
    */

    @Test
    public void registerLessAllowedTimeTwoProjects() throws Exception{
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
        Project project1=SoftwareHouse.getProjects().get(0);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID02="Project02";
        SoftwareHouse.createProject(PID02);
        Project project2=SoftwareHouse.getProjects().get(1);
        assertEquals(2,SoftwareHouse.getDatabase().getNumberOfProjects());

        // Step 4
        SoftwareHouse.logIn(EID01);
        assertEquals("CBG",SoftwareHouse.getCurrentEmployee().getEmployeeID());
        Employee currentEmployee=SoftwareHouse.getCurrentEmployee();
        assertEquals(0,currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(0);
        assertEquals(1,currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(1);
        assertEquals(2,currentEmployee.getProjectLeaderList().size());
        assertEquals(1,project2.getProjectID());

        // Step 5
        String AID01="Assignment01";
        assertEquals(0,project1.getAssignmentList().size());
        project1.createAssignment(AID01);
        assertEquals(1,project1.getAssignmentList().size());
        Assignment assignment1=project1.getAssignmentByName(AID01);

        assertEquals(0,project2.getAssignmentList().size());
        String AID02="Assignment02";
        project2.createAssignment(AID02);
        assertEquals(1,project2.getAssignmentList().size());
        Assignment assignment2=project2.getAssignmentByName(AID02);


        // Step 6
        WeekCalendar week1 = new WeekCalendar(2017,1);

        assignment1.manAssignment(currentEmployee, week1,1,20);
        assignment2.manAssignment(currentEmployee, week1,1,20);

        DayCalendar day1 = new DayCalendar(week1,1);
        SoftwareHouse.registerTime(day1,4,0);
        SoftwareHouse.registerTime(day1,4,1);
        assertEquals(8,SoftwareHouse.getCurrentEmployee().getRegisteredHalfHours(day1));
    }

    /*
   Test 5:
   Register 8 hours in one day at two different assignments.

   Step 1:
   Create a system

   Step 2:
   Add an employee

   Step 3:
   Add two projects

   Step 4:
   Become Projectleader

   Step 5:
   Adds assignments

   Step 6:
   Registers 4 hours to each project
    */

    @Test
    public void registerAllowedTimeTwoProjects() throws Exception{
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
        Project project1=SoftwareHouse.getProjects().get(0);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID02="Project02";
        SoftwareHouse.createProject(PID02);
        Project project2=SoftwareHouse.getProjects().get(1);
        assertEquals(2,SoftwareHouse.getDatabase().getNumberOfProjects());

        // Step 4
        SoftwareHouse.logIn(EID01);
        assertEquals("CBG",SoftwareHouse.getCurrentEmployee().getEmployeeID());
        Employee currentEmployee=SoftwareHouse.getCurrentEmployee();
        assertEquals(0,currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(0);
        assertEquals(1,currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(1);
        assertEquals(2,currentEmployee.getProjectLeaderList().size());
        assertEquals(1,project2.getProjectID());

        // Step 5
        String AID01="Assignment01";
        assertEquals(0,project1.getAssignmentList().size());
        project1.createAssignment(AID01);
        assertEquals(1,project1.getAssignmentList().size());
        Assignment assignment1=project1.getAssignmentByName(AID01);

        assertEquals(0,project2.getAssignmentList().size());
        String AID02="Assignment02";
        project2.createAssignment(AID02);
        assertEquals(1,project2.getAssignmentList().size());
        Assignment assignment2=project2.getAssignmentByName(AID02);


        // Step 6
        WeekCalendar week1 = new WeekCalendar(2017,1);

        assignment1.manAssignment(currentEmployee, week1,1,20);
        assignment2.manAssignment(currentEmployee, week1,1,20);

        DayCalendar day1 = new DayCalendar(week1,1);
        SoftwareHouse.registerTime(day1,8,0);
        SoftwareHouse.registerTime(day1,8,1);
        assertEquals(16,SoftwareHouse.getCurrentEmployee().getRegisteredHalfHours(day1));
    }

     /*
   Test 5:
   Register 12 hours in one day at two different assignments.

   Step 1:
   Create a system

   Step 2:
   Add an employee

   Step 3:
   Add two projects

   Step 4:
   Become Projectleader

   Step 5:
   Adds assignments

   Step 6:
   Registers 6 hours to each project
    */

    @Test
    public void registerMoreThanAllowedTimeTwoProjects() throws Exception{
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
        Project project1=SoftwareHouse.getProjects().get(0);
        assertEquals(1,SoftwareHouse.getDatabase().getNumberOfProjects());
        String PID02="Project02";
        SoftwareHouse.createProject(PID02);
        Project project2=SoftwareHouse.getProjects().get(1);
        assertEquals(2,SoftwareHouse.getDatabase().getNumberOfProjects());

        // Step 4
        SoftwareHouse.logIn(EID01);
        assertEquals("CBG",SoftwareHouse.getCurrentEmployee().getEmployeeID());
        Employee currentEmployee=SoftwareHouse.getCurrentEmployee();
        assertEquals(0,currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(0);
        assertEquals(1,currentEmployee.getProjectLeaderList().size());
        SoftwareHouse.becomeProjectLeader(1);
        assertEquals(2,currentEmployee.getProjectLeaderList().size());
        assertEquals(1,project2.getProjectID());

        // Step 5
        String AID01="Assignment01";
        assertEquals(0,project1.getAssignmentList().size());
        project1.createAssignment(AID01);
        assertEquals(1,project1.getAssignmentList().size());
        Assignment assignment1=project1.getAssignmentByName(AID01);

        assertEquals(0,project2.getAssignmentList().size());
        String AID02="Assignment02";
        project2.createAssignment(AID02);
        assertEquals(1,project2.getAssignmentList().size());
        Assignment assignment2=project2.getAssignmentByName(AID02);


        // Step 6
        WeekCalendar week1 = new WeekCalendar(2017,1);

        assignment1.manAssignment(currentEmployee, week1,1,20);
        assignment2.manAssignment(currentEmployee, week1,1,20);

        DayCalendar day1 = new DayCalendar(week1,1);
        SoftwareHouse.registerTime(day1,12,0);
        try {
            SoftwareHouse.registerTime(day1, 12, 1);
        } catch (TooManyHoursException e){
            assertEquals("You have already registered too many hours today",e.getMessage());

        }
        assertEquals(12,SoftwareHouse.getCurrentEmployee().getRegisteredHalfHours(day1));
    }





}
