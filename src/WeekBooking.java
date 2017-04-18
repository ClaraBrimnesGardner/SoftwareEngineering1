/**
 * Created by Tobias on 18/04/2017.
 */

public class WeekBooking {

    private WeekCalendar weekCalendar;
    private int bookedHours;

    public WeekBooking(WeekCalendar weekCalendar, int bookedHours) {
        this.weekCalendar = weekCalendar;
        this.bookedHours = bookedHours;
    }

    public int getBookedHours() {
        return bookedHours;
    }

    public WeekCalendar getWeekCalendar() {
        return weekCalendar;
    }
}
