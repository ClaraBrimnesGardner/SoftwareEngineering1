/**
 * Created by Tobias on 17/04/2017.
 */
public class WeekCalendar {
    // Declaring fields
    private int weekNumber;
    private int year;

    // Constructor
    public WeekCalendar(int year, int weekNumber) {
        this.weekNumber = weekNumber;
        this.year = year;
    }

    // Getter methods
    public int getWeekNumber() {
        return weekNumber;
    }

    public int getYear() { return year;}

    // Method which determines whether a given week is after this week
    public boolean after(WeekCalendar other) {
        if (other.getYear() < year) {
            return true;
        }
        else if (other.getYear() == year) {
            return (other.getWeekNumber() <= weekNumber);
        }
        return false;
    }

    // Method which determines whether a given week is before this week
    public boolean before(WeekCalendar other) {
        if (other.getYear() > year) {
            return true;
        }
        else if (other.getYear() == year) {
            return (other.getWeekNumber() >= weekNumber);
        }
        return false;
    }

    // Method which returns a WeekCalendar a given number of weeks after this week
    public WeekCalendar increaseWeek(int duration) {
        int newWeekNumber=weekNumber+duration;
        int newYear=year;
        while (newWeekNumber > 52) {
            newWeekNumber -= 52;
            newYear++;
        }
        WeekCalendar newWeek= new WeekCalendar(newYear, newWeekNumber);
        return newWeek;
    }

    // Equals method
    public boolean equals(Object o){
        if(!(o instanceof WeekCalendar)){
            return false;
        }
        if(weekNumber==((WeekCalendar) o).getWeekNumber() && year==((WeekCalendar) o).getYear()){
            return true;
        }
        return false;
    }

    // Calculates the difference in weeks
    public int weeksTo(WeekCalendar weekCalendar) {
        int weeks = weekCalendar.getWeekNumber()-weekNumber;
        int years = weekCalendar.getYear()-year;
        weeks += years*52;
        return weeks;

    }


}
