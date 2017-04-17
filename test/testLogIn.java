/**
 * Created by clarabrimnesgardner on 14/04/2017.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class testLogIn {
    /*
    Test that the LogIn and LogOff functions work
     */
    @Test
    public void testLogIn() throws WrongInputException{
        // Creates a system
        System SoftwareHouse = new System();
        assertEquals(SoftwareHouse.getCurrentEmployee(),null);
        SoftwareHouse.createEmployee("Employee1");
        SoftwareHouse.logIn("Employee1");
        assertEquals(SoftwareHouse.getCurrentEmployee().getEmployeeID(),"Employee1");
        assertEquals(SoftwareHouse.getEmployees().get(0),SoftwareHouse.getCurrentEmployee());
        SoftwareHouse.logOff();
        assertEquals(SoftwareHouse.getCurrentEmployee(),null);

    }
}
