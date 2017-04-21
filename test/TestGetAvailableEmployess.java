/**
 * Created by Tobias on 17/04/2017.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGetAvailableEmployess {
    @Test
    public void testGetTwoEmployess() throws WrongInputException {
        System SoftwareHouse = new System();
        // Adds an employee
        String ID="Employee1";
        SoftwareHouse.createEmployee(ID);
        // Adds another employee
        String ID2 = "Employee2";
        SoftwareHouse.createEmployee(ID2);

        SoftwareHouse.createProject("Test");

        WeekCalendar week1 = new WeekCalendar(2017,1);

        assertEquals(2,SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,38).size());
        assertEquals(0,SoftwareHouse.getDatabase().getAvailableEmployees(week1,1,40).size());

    }
}
