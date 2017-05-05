import org.junit.Test;

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


}
