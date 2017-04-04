import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLogin {

    @Test
    public void testUserLogin() {
        System softwareHouse = new System();

        // Tjekker om der er logged ind
        assertFalse(softwareHouse.employeeLoggedIn());

        String workerID = "Employee01";
        Employee worker = new Employee(workerID);
        softwareHouse.addEmployee(worker);
        softwareHouse.employeeLogin(worker);

        // Tjekker om der er logget ind
        assertTrue(softwareHouse.employeeLoggedIn());

    }

    @Test
    public void testUserLogoff() {
        System softwareHouse = new System();
        String workerID = "Employee01";
        Employee worker = new Employee(workerID);
        softwareHouse.addEmployee(worker);

        // Tjekker om der er logget ind
        assertFalse(softwareHouse.employeeLoggedIn());
        softwareHouse.employeeLogin(worker);
        assertTrue(softwareHouse.employeeLoggedIn());

        // Logger ud
        softwareHouse.employeeLogoff();
        assertFalse(softwareHouse.employeeLoggedIn());

    }
}