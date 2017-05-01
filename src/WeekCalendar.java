/**
 * Created by Tobias on 17/04/2017.
 */
public class WeekCalendar {
    private int weekNumber;
    private int year;

    // constructor
    public WeekCalendar(int year, int weekNumber) {
        this.weekNumber = weekNumber;
        this.year = year;
    }

    public int getYear() { return year;}

    public int getWeekNumber() {
        return weekNumber;
    }

    public int weeksTo(WeekCalendar endWeek) {
        return (endWeek.getYear()-year)*52 + endWeek.getWeekNumber() - weekNumber;
    }

    public boolean before(WeekCalendar other) {
        if (other.getYear() > year) {
            return true;
        }
            else if (other.getYear() == year) {
            return (other.getWeekNumber() >= weekNumber);
        }
        return false;
    }

    public boolean after(WeekCalendar other) {
        if (other.getYear() < year) {
            return true;
        }
            else if (other.getYear() == year) {
                return (other.getWeekNumber() <= weekNumber);
            }
        return false;
    }

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
}
