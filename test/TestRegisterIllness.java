import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by clarabrimnesgardner on 05/05/2017.
 */
public class TestRegisterIllness {

    @Test
    public void testRegisterIllness()throws Exception{
        System SoftwareHouse = new System();

        //Create Employee
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);

        // Get Employee
        SoftwareHouse.logIn(EID01);
        assertEquals("CBG",SoftwareHouse.getCurrentEmployee().getEmployeeID());
        Employee currentEmployee=SoftwareHouse.getCurrentEmployee();

        // WeekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,1);
        DayCalendar day1 = new DayCalendar(week1,1);
        currentEmployee.registerIllness(day1, 16);

        assertEquals(16,currentEmployee.getRegisteredHalfHours(day1));
    }

    @Test
    public void testIllnessAlreadyRegisteredTime() throws Exception{
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


        WeekCalendar week1 = new WeekCalendar(2017,1);
        currentAssignment.manAssignment(currentEmployee, week1,1,20);

        DayCalendar day1 = new DayCalendar(week1,1);
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01,currentEmployee);
        currentAssignmentEmployee.registerTime(day1,8);

        // Registers illness
        currentEmployee.registerIllness(day1, 8);
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),16);
    }

    @Test
    public void testRegisterTooMuchIllness() throws Exception{
        System SoftwareHouse = new System();

        //Create Employee
        String EID01 = "CBG";
        SoftwareHouse.createEmployee(EID01);

        // Get Employee
        SoftwareHouse.logIn(EID01);
        assertEquals("CBG",SoftwareHouse.getCurrentEmployee().getEmployeeID());
        Employee currentEmployee=SoftwareHouse.getCurrentEmployee();

        // WeekCalendar
        WeekCalendar week1 = new WeekCalendar(2017,1);
        DayCalendar day1 = new DayCalendar(week1,1);
        try{
            currentEmployee.registerIllness(day1, 17);
        } catch (TooManyHoursException e){
            assertEquals("You have registered too many hours today",e.getMessage());
        }

        assertEquals(0,currentEmployee.getRegisteredHalfHours(day1));
    }

    @Test
    public void testRegisterHoursAndToMuchIllness() throws Exception{
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


        WeekCalendar week1 = new WeekCalendar(2017,1);
        currentAssignment.manAssignment(currentEmployee, week1,1,20);

        DayCalendar day1 = new DayCalendar(week1,1);
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01,currentEmployee);
        currentAssignmentEmployee.registerTime(day1,8);

        // Registers illness
        try {
            currentEmployee.registerIllness(day1, 9);
        } catch (TooManyHoursException e){
            assertEquals("You have registered too many hours today", e.getMessage());
        }
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),8);
    }

    @Test
    public void testRegisterIllnessAndToManyHours() throws Exception{
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


        WeekCalendar week1 = new WeekCalendar(2017,1);
        currentAssignment.manAssignment(currentEmployee, week1,1,20);

        DayCalendar day1 = new DayCalendar(week1,1);
        AssignmentEmployee currentAssignmentEmployee = SoftwareHouse.getDatabase().getAssignmentEmployeeByNameAndEmployee(AID01,currentEmployee);
        currentEmployee.registerIllness(day1, 8);

        // Registers illness
        try {
            currentAssignmentEmployee.registerTime(day1,9);
        } catch (TooManyHoursException e){
            assertEquals("You have registered too many hours today", e.getMessage());
        }
        assertEquals(currentEmployee.getRegisteredHalfHours(day1),8);
    }


}
