import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
  * Created by clarabrimnesgardner on 27/03/2017.
 */

public class TestAddEmployee {
    /*
    Tests that the method addEmployee adds one Employee with the correct ID
     */
    @Test
    public void testAddEmployee() throws Exception {
        System SoftwareHouse = new System();
        String ID = "CBG";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(),1);
        assertEquals(SoftwareHouse.getEmployees().get(0).getEmployeeID(), "CBG");
    }

    /*
    Test that the method only adds an Employee, when no current Employee with that ID is registered
     */

    @Test
    public void testAddExistingEmployee() throws Exception{
        System SoftwareHouse = new System();
        String ID = "CBG";
        SoftwareHouse.createEmployee(ID);
        assertEquals(SoftwareHouse.getEmployees().size(),1);
        assertEquals(SoftwareHouse.getEmployees().get(0).getEmployeeID(), "CBG");
        try{
            SoftwareHouse.createEmployee(ID);
        } catch (WrongInputException e){
            assertEquals(e.getMessage(),"Employee ID is used");
        }
    }

    @Test
    public void testAddTwoEmployees() throws Exception{
        System SoftwareHouse = new System();
        String ID1 = "CBG";
        SoftwareHouse.createEmployee(ID1);
        String ID2 = "SDN";
        SoftwareHouse.createEmployee(ID2);
        assertEquals(SoftwareHouse.getEmployees().size(),2);
    }
}
