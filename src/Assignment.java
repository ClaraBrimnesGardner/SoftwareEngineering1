/**
 * Created by clarabrimnesgardner on 17/04/2017.
 */

public class Assignment {
    public String name;
    public int assignmentID;
    private Project project;
    private int budgetedTime;
    private int bookedTime;
    private Database database;


    // Constructor
    public Assignment(String name, Project project){
        this.name=name;
        this.project=project;
        bookedTime=0;
        budgetedTime=0;
    }

    // Getter methods
    public int getBookedTime() {return bookedTime;}

    public int getBudgetedTime(){return budgetedTime;}

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
    public void manAssignment(Employee employee, WeekCalendar week, int duration, int hours) throws Exception{
        if(hours < database.getMinBookedHalfHours()){
            throw new TooManyHoursException("You can't book less than 0 hours");
        }
        if((bookedTime + hours) > budgetedTime){
            throw new TooManyHoursException("The hours you want to book exceeds the budgetted time");
        }
        AssignmentEmployee assignmentEmployee = new AssignmentEmployee(employee, this);
        database.addAssignmentEmployee(assignmentEmployee);

        WeekCalendar endWeek = new WeekCalendar(week.getYear(),week.getWeekNumber());
        endWeek=endWeek.increaseWeek(duration-1);

        int availableHours;
        while(hours>0 && week.before(endWeek)){
            WeekCalendar newWeek = new WeekCalendar(week.getYear(),week.getWeekNumber());

            availableHours=employee.getAvailableHours(newWeek,1);
            if(availableHours<=hours){
                bookedTime+=availableHours;
                WeekBooking newBooking = new WeekBooking(newWeek,availableHours);
                assignmentEmployee.addBooking(newBooking);
                hours=hours-availableHours;
            }
            else {
                bookedTime+=hours;
                WeekBooking newBooking = new WeekBooking(newWeek, hours);
                assignmentEmployee.addBooking(newBooking);
                hours=0;
            }
            week=week.increaseWeek(1);
        }
    }

    public void manAssignmentWithoutEndTime(Employee employee) throws WrongInputException{
        AssignmentEmployee assignmentEmployee = new AssignmentEmployee(employee, this);
        if(database!=null){
            database.addAssignmentEmployee(assignmentEmployee);
        }
    }







}
