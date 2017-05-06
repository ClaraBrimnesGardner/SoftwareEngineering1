import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by clarabrimnesgardner on 06/05/2017.
 */
public class WhiteBoxTestCreateEmployee {
    /*
    White Box tests to the function createEmployee
    */
    /*
    Test 1
    Input data set W.1
    This test tests the method createEmployee with the property: "Employee ID exceeds maximum characters

    Step 1:
    Create a system

    Step 2:
    Give an employee ID, which is longer than 4 characters

    Step 3:
    Try to create employee

    */

    @Test
    public void testCreateEmployeeEmployeeIDToLong() throws Exception {
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        String EID01 = "Clara";

        // Step 3
        assertEquals(0,SoftwareHouse.getEmployees().size());
        try{
            SoftwareHouse.createEmployee(EID01);
        } catch (WrongInputException e){
            assertEquals("ID is to long", e.getMessage());
        }
        assertEquals(0, SoftwareHouse.getEmployees().size());
    }

    /*
    Test 2
    Input data set W.2
    Tests the method createEmployee with the property: "Employee ID doesn't exceeed maximum characters" and "Employee
    is the first employee to be created"
    Step 1:
    Create system

    Step 2:
    Give an employee ID

    Step 3:
    Create employee
     */

    @Test
    public void testCreateEmployeeFirstEmployee() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        String EID01 = "CBG";

        // Step 3
        assertEquals(0,SoftwareHouse.getEmployees().size());
        SoftwareHouse.createEmployee(EID01);
        Employee currentEmployee = SoftwareHouse.getEmployees().get(0);
        assertEquals(1,SoftwareHouse.getEmployees().size());
        assertEquals(1,currentEmployee.getAssignmentEmployeeList().size());
    }

    /*
    Test 3
    Input data set W.3
    Tests the method createEmployee with the properties: "Employee ID doesn't exceed maximum", "Employee is second to
    be created" and "Employee ID is already used"
    Step 1:
    Create system

    Step 2:
    Give an employee ID

    Step 3:
    Create an employee with ID

    Step 4:
    Try to create another employee with same ID

     */

    @Test
    public void testCreateEmployeeSecondEmployeeEmployeeIDUsed() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        String EID01 = "CBG";

        // Step 3
        assertEquals(0,SoftwareHouse.getEmployees().size());
        SoftwareHouse.createEmployee(EID01);
        Employee currentEmployee = SoftwareHouse.getEmployees().get(0);
        assertEquals(1,SoftwareHouse.getEmployees().size());
        assertEquals(1,currentEmployee.getAssignmentEmployeeList().size());

        // Step 4
        try{
            SoftwareHouse.createEmployee(EID01);
        } catch (WrongInputException e){
            assertEquals("Employee ID is used", e.getMessage());
        }
        assertEquals(1,SoftwareHouse.getEmployees().size());
    }

    /*
    Test 4
    Input data set 4
    Tests the method createEmployee with the properties: "Employee ID doesn't exceed maximum", "More than one
    employee has been created before" and "Employee ID is not used"
    Step 1:
    Create system

    Step 2:
    Give an employee ID

    Step 3:
    Create employee

    Step 4:
    Give another ID

    Step 5:
    Create another employee

    Step 6:
    Give a third ID

    Step 7:
    Create a third employee
     */

    @Test
    public void testCreateEmployeeMoreThanTwoEmployeesEmployeeIDNotUsed() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        String EID01 = "CBG";

        // Step 3
        assertEquals(0,SoftwareHouse.getEmployees().size());
        SoftwareHouse.createEmployee(EID01);
        Employee employee1 = SoftwareHouse.getEmployees().get(0);
        assertEquals(1,SoftwareHouse.getEmployees().size());
        assertEquals(1,employee1.getAssignmentEmployeeList().size());

        // Step 4
        String EID02 = "SDN";

        // Step 5
        SoftwareHouse.createEmployee(EID02);
        Employee employee2 = SoftwareHouse.getEmployees().get(1);
        assertEquals(2,SoftwareHouse.getEmployees().size());
        assertEquals(1,employee2.getAssignmentEmployeeList().size());

        // Step 6
        String EID03 = "TER";

        // Step 7
        SoftwareHouse.createEmployee(EID03);
        Employee employee3 = SoftwareHouse.getEmployees().get(2);
        assertEquals(3,SoftwareHouse.getEmployees().size());
        assertEquals(1,employee2.getAssignmentEmployeeList().size());
    }

}
