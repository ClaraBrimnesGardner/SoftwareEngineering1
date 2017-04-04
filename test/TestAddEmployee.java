import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by clarabrimnesgardner on 27/03/2017.
 */
public class TestAddEmployee {
    /*
    Tests that the method addEmployee adds one Employee with the correct ID
     */
    @Test
    public void testAddEmployee(){
        System SoftwareHouse = new System();
        String ID = "Employee1";
        Employee worker = new Employee(ID);
        SoftwareHouse.addEmployee(worker);
        assertEquals(SoftwareHouse.getEmployeeList().size(),1);
        assertEquals(SoftwareHouse.employeeByID(ID).getEmployeeID(),ID);
        assertEquals(SoftwareHouse.employeeByID(ID).getSystem(),SoftwareHouse);

    }
    /*
    Test that the method only adds an Employee, when no current Employee with that ID is registered

     */
    @Test
    public void testAddAlreadyRegisteredEmployee() {
        System SoftwareHouse = new System();
        String ID = "Employee1";
        Employee worker = new Employee(ID);
        SoftwareHouse.addEmployee(worker);
        SoftwareHouse.addEmployee(worker);
        assertEquals(SoftwareHouse.getEmployeeList().size(), 1);
    }


}
