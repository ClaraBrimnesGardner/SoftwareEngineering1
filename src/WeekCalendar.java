/**
 * Created by Tobias on 17/04/2017.
 */
public class WeekCalendar {
    private int weekNumber;
    private int year;
    private int bookedHours = 0;

    // constructor
    public void weekCalendar(int year, int weekNumber) {
        this.weekNumber = weekNumber;
        this.year = year;


    }

    public void setBookedHours(int halfHours) {
        this.bookedHours = halfHours;
    }

    public int getBookedHours() {
        return bookedHours;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public int weeksTo(WeekCalendar endWeek) {
        return endWeek.getWeekNumber() - weekNumber;
    }
}