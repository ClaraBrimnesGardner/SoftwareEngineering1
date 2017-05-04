/**
 * Created by clarabrimnesgardner on 25/04/2017.
 */
public class DayCalendar {
    WeekCalendar weekCalendar;
    int dayNumber;

    // Constructor
    public DayCalendar(WeekCalendar weekCalendar, int dayNumber) {
        this.weekCalendar=weekCalendar;
        this.dayNumber=dayNumber;
    }

    // Getter methods
    public WeekCalendar getWeekCalendar(){
        return weekCalendar;
    }
    public int getDayNumber(){return dayNumber;}

    // Equals method
    public boolean equals(Object o){
        if(!(o instanceof DayCalendar)){
            return false;
        }
        if(dayNumber==((DayCalendar) o).getDayNumber() && weekCalendar==((DayCalendar) o).getWeekCalendar()){
            return true;
        }
        return false;
    }
}
