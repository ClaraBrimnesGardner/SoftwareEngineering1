import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by clarabrimnesgardner on 05/05/2017.
 */
public class TestBlackBoxUseCase1 {
    /*
    Black box tests for the revised use case 4 which concentrates the methods getAvailableEmployees and manAssignment
     */

    /*
    Test 1
    Tests the main scenario in use case 1: The user provides a name for the project, and the project is created
    Step 1:
    A system is created

    Step 2:
    The user gives a name for the project

    Step 3:
    The project is created
     */

    @Test
    public void testUseCase1MainScenario() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        String PID01 = "Project01";

        // Step 3
        assertEquals(1,SoftwareHouse.getProjects().size());
        SoftwareHouse.createProject(PID01);
        assertEquals(2,SoftwareHouse.getProjects().size());
    }

    /*
    Test 2
    Test alternative scenario 2.a: The user provides a name, which is already used
    Step 1:
    A system is created

    Step 2:
    A name is provided

    Step 3:
    A project is created

    Step 4:
    Another project with the same name is created
     */

    @Test
    public void testUseCase1() throws Exception{
        // Step 1
        System SoftwareHouse = new System();

        // Step 2
        String PID01 = "Project01";

        // Step 3
        assertEquals(1, SoftwareHouse.getDatabase().getNumberOfProjects());
        SoftwareHouse.createProject(PID01);
        assertEquals(2, SoftwareHouse.getDatabase().getNumberOfProjects());

        // Step 4
        try{
            SoftwareHouse.createProject(PID01);
        } catch(WrongInputException e){
            assertEquals("Project name is used", e.getMessage());
        }
        assertEquals(2,SoftwareHouse.getDatabase().getNumberOfProjects());

    }


}
