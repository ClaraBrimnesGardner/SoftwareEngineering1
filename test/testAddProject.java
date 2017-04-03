import org.junit.jupiter.api.Test;


public class testAddProject {

    @Test
    public void testUserLoggedIn() {
        System softwareHouse = new System();

        String workerID = "Employee01";
        softwareHouse.addEmployee(workerID);
        softwareHouse.login(workerID);

        // Tjekker om der er logget ind
        assertTrue(softwareHouse.employeeLoggedIn());

        // Tilføjer projektet
        String projectName = "Project01";
        softwareHouse.addProject(projectName);

        // Tjekker om der er et projekt i listen
        assertEquals(1,softwareHouse.getProjects().size());

    }

    @Test
    public void testUserNotLoggedIn() {
        System softwareHouse = new System();
        String workerID = "Employee01";
        softwareHouse.addEmployee(workerID);

        // Tjekker om der er logget ind
        assertFalse(softwareHouse.employeeLoggedIn());

        String projectID = "Project01";
        // Tjekker om der kommer en fejlmeddelelse
        try {
            softwareHouse.addProject(projectID);
        }
        catch (OperationNotAllowedExeption e) {
            assertEquals(e,"You have to be logged in, in order to add a project");
        }
    }
}