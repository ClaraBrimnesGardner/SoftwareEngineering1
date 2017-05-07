/**
 * Created by clarabrimnesgardner on 25/04/2017.
 */
public class DayCalendar {
    private WeekCalendar weekCalendar;
    private int dayNumber;

    // Constructor
    public DayCalendar(WeekCalendar weekCalendar, int dayNumber) throws WrongInputException {
        this.weekCalendar=weekCalendar;
        this.dayNumber=dayNumber;

        if (dayNumber<1 || dayNumber>7) throw new WrongInputException("Day has to be a number between 1 and 7");
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
        if(dayNumber==((DayCalendar) o).getDayNumber() && weekCalendar.equals(((DayCalendar) o).getWeekCalendar())){
            return true;
        }
        return false;
    }
}
