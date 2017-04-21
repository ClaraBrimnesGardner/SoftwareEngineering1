/**
 * Created by clarabrimnesgardner on 17/04/2017.
 */
public class Assignment {
    private String name;
    private Project project;
    private int budgetedTime;
    private int bookedTime;
    private Database database;




    // Constructor
    public Assignment(String name, Project project){
        this.name=name;
        this.project=project;
        bookedTime=0;
    }

    // Getter methods
    public String getName(){
        return name;
    }

    public Project getProject(){
        return project;
    }

    // Setter methods
    public void setBudgetedTime(int budgetedTime){
        this.budgetedTime=budgetedTime;
    }
    public void setDatabase(Database database){
        this.database=database;
    }

    // Method to man an assignment
    public void manAssignment(Employee employee, WeekCalendar week, int duration, int hours) throws WrongInputException{
        AssignmentEmployee assignmentEmployee = new AssignmentEmployee(employee);
        if(database!=null){
            database.addAssignmentEmployee(assignmentEmployee);
        }


    }







}
