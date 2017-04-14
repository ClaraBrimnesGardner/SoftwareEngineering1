/**
 * Created by clarabrimnesgardner on 14/04/2017.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class testBecomeProjectleader {
    @Test
    public void testBecomeProjectLeader() throws WrongInputException{
        System SoftwareHouse = new System();
        // Adds an employee
        String ID="Employee1";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project
        SoftwareHouse.createProject("Project1");
        // Login as employee
        SoftwareHouse.logIn(ID);
        assertEquals(SoftwareHouse.employee.getEmployeeID(),ID);
        assertEquals(SoftwareHouse.employee,SoftwareHouse.getEmployees().get(0));

        // Become projectLeader

        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),0);
        SoftwareHouse.employee.becomeProjectLeader(0);
        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),1);

    }
    /*
    Test that you can only become a projectleader of a project without a leader
     */

    @Test
    public void testOnlyOneProjectLeader() throws WrongInputException{
        System SoftwareHouse = new System();
        // Adds an employee
        String ID="Employee1";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project
        SoftwareHouse.createProject("Project1");
        // Login as employee
        SoftwareHouse.logIn(ID);
        assertEquals(SoftwareHouse.employee.getEmployeeID(),ID);
        assertEquals(SoftwareHouse.employee,SoftwareHouse.getEmployees().get(0));

        // Become projectLeader

        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),0);
        SoftwareHouse.employee.becomeProjectLeader(0);
        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),1);
        SoftwareHouse.logOff();

        // Creates a new employee
        String ID2="Employee2";
        SoftwareHouse.createEmployee(ID2);
        SoftwareHouse.logIn(ID2);
        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),0);
        SoftwareHouse.employee.becomeProjectLeader(0);
        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),0);

    }
    @Test
    public void testBecomeProjectLeaderOfTwoProjects() throws WrongInputException{
        System SoftwareHouse = new System();
        // Adds an employee
        String ID="Employee1";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(),1);

        // Adds a project
        SoftwareHouse.createProject("Project1");
        // Login as employee
        SoftwareHouse.logIn(ID);
        assertEquals(SoftwareHouse.employee.getEmployeeID(),ID);
        assertEquals(SoftwareHouse.employee,SoftwareHouse.getEmployees().get(0));

        // Become projectLeader

        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),0);
        SoftwareHouse.employee.becomeProjectLeader(0);
        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),1);

        // Adds another project
        SoftwareHouse.createProject("Project2");
        SoftwareHouse.employee.becomeProjectLeader(1);
        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),2);
        SoftwareHouse.employee.becomeProjectLeader(1);
        assertEquals(SoftwareHouse.employee.getProjectLeaderList().size(),2);

    }

}
