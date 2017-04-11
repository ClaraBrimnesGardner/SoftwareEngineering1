
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestAddProject {
    /*
    Tests that the method addProject adds one Project with the correct ID
     */
    @Test
    public void testAddProject(){
        // Creates a system
        System SoftwareHouse = new System();
        // Creates a project
        String projectID = "project1";
        Project project = new Project(projectID);
        // Creates an employee and adds him to the system
        String employeeID = "Employee1";
        Employee worker = new Employee(employeeID);
        SoftwareHouse.addEmployee(worker);

        // The employee adds the project to the system
        Employee employee1=SoftwareHouse.employeeByID(employeeID);
        employee1.addProject(project);
        assertEquals(SoftwareHouse.getProjectList().size(),1);
        assertEquals(SoftwareHouse.projectByID(projectID).getProjectID(),projectID);
        assertEquals(SoftwareHouse.projectByID(projectID).getSystem(),SoftwareHouse);
    }

      /*
    Test that the method only adds a project, when no current project with that ID is registered

     */
    @Test
    public void testAddExistingProject(){
        System SoftwareHouse = new System();
        // Creates two projects
        String projectID = "project";
        Project project1 = new Project(projectID);
        Project project2 = new Project(projectID);
        // Creates an employee and adds him to the system
        String employeeID = "Employee1";
        Employee worker = new Employee(employeeID);
        SoftwareHouse.addEmployee(worker);

        // Employee adds the first project to the system
        Employee employee1=SoftwareHouse.employeeByID(employeeID);
        employee1.addProject(project1);
        assertEquals(SoftwareHouse.getProjectList().size(),1);
        assertEquals(SoftwareHouse.projectByID(projectID).getProjectID(),projectID);
        assertEquals(SoftwareHouse.projectByID(projectID).getSystem(),SoftwareHouse);

        // Employee adds the second project to the system
        employee1.addProject(project1);
        assertEquals(SoftwareHouse.getProjectList().size(),1);
    }


}

