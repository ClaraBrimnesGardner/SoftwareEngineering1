
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestAddProject {
    /*
    Tests that the method addProject adds one Project with the correct ID
     */
    @Test
    public void testAddProject() throws Exception {
        // Creates a system
        System SoftwareHouse = new System();
        // Add a project to the system
        SoftwareHouse.createProject("test");

        assertEquals(SoftwareHouse.getProjects().size(),2);

        assertEquals(SoftwareHouse.getProjects().get(1).getName(),"test");
    }


    /*
    Tests that the method addProject only adds a project, when no current project with that ID is registered
     */
    @Test
    public void testAddExistingProject() throws Exception {
        System SoftwareHouse = new System();
        // Add a project to the system
        SoftwareHouse.createProject("test");
        assertEquals(SoftwareHouse.getProjects().size(),2);
        assertEquals(SoftwareHouse.getProjects().get(1).getName(),"test");
        // Add another project to the system with same name
        try {
            SoftwareHouse.createProject("test");
        } catch (WrongInputException e){
            assertEquals("Projectname is used", e.getMessage());
        }
        assertEquals(SoftwareHouse.getProjects().size(),2);


    }
    /*
    Test that two Projects can be added
     */
    @Test
    public void testAddTwoProjects() throws Exception{
        System SoftwareHouse = new System();
        // Add a project to the system
        SoftwareHouse.createProject("test");
        SoftwareHouse.createProject("test1");
        assertEquals(3,SoftwareHouse.getProjects().size());
    }




}

