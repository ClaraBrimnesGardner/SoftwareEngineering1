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
        SoftwareHouse.addEmployee(ID);
        assertEquals(SoftwareHouse.getEmployeeList().size(),1);

    }
}
