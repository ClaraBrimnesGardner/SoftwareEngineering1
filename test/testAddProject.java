import org.junit.jupiter.api.Test;

public class testAddProject {

    @Test
    public void testUserLoggedIn() {
        System softwareHouse = new System();

        String workerID = "Employee01";
        Employee worker = new Employee(workerID);
        softwareHouse.addEmployee(worker);
        softwareHouse.login(workerID);

        // Tjekker om der er logget ind
        assertTrue(softwareHouse.employeeLoggedIn());

        // Tilføjer projektet
        String projectName = "Project01";
        softwareHouse.addProject(projectName);

        // Tjekker om der er et projekt i listen
        assertEquals(1,softwareHouse.getProjects().size());

    }
}