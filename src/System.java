/**
  * Created by clarabrimnesgardner on 27/03/2017.
 */
import java.util.*;

public class System {
    private boolean loggedIn = false;
    private List<Employee> employeeList = new ArrayList<Employee>();
    private List<Project> projectList = new ArrayList<Project>();


    // Method to addEmployee
    public void addEmployee(Employee worker){
        if (!employeeList.contains(worker)) {
            employeeList.add(worker);
            worker.setSystem(this);

        }
    }

    // Method to add Project to projectList
    public void addProjectToList(Project project){
        if(!projectList.contains(project)){
            projectList.add(project);
            project.setSystem(this);
        }
    }

    /*
     * Getter methods
     */
    // Method to get list om employees
    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    // Method to get list of projects
    public List<Project> getProjectList() {return projectList;}

    // Method to get an employee with af specific ID
    public Employee employeeByID(String ID){
        for(int i=0;i<employeeList.size();i++){
            if(employeeList.get(i).getEmployeeID().equals(ID)) {
                return employeeList.get(i);
            }
        }
        return null;
    }

    // Method to get a project with af specific ID
    public Project projectByID(String ID){
        for(int i=0;i<projectList.size();i++){
            if(projectList.get(i).getProjectID().equals(ID)){
                return projectList.get(i);
            }
        }
        return null;
    }

    public void employeeLogin(Employee worker) {
        if (employeeList.contains(worker)) {
            loggedIn = true;
        }
    }

    public void employeeLogoff() {
        loggedIn = false;
    }

    public boolean employeeLoggedIn() {
        return loggedIn;
    }
    }