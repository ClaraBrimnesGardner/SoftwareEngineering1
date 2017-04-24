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
        WeekCalendar endWeek=new WeekCalendar(week.getYear(),week.getWeekNumber());
        endWeek.increaseWeek(duration);
        WeekCalendar currentWeek=new WeekCalendar(week.getYear(),week.getWeekNumber());
        int availableHours;
        while(currentWeek.before(endWeek) && hours>0){
            currentWeek.increaseWeek(1);
            availableHours=employee.availableHours(currentWeek,1);
            if (availableHours >= hours) {
                WeekBooking newBooking = new WeekBooking(week, hours);
                assignmentEmployee.addBooking(newBooking);
                hours=hours-hours;
            } else {
                WeekBooking newBooking = new WeekBooking(week, availableHours);
                assignmentEmployee.addBooking(newBooking);
                hours=hours-availableHours;
            }
        }





    }







}
