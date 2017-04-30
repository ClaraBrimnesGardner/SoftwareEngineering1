/**
 * Created by clarabrimnesgardner on 25/04/2017.
 */
public class DayRegistration {
    private DayCalendar dayCalendar;
    private int registeredHours;

    // Constructor
    public DayRegistration(DayCalendar dayCalendar, int registeredHours){
        this.dayCalendar=dayCalendar;
        this.registeredHours=registeredHours;
    }

    // Getter methods
    public DayCalendar getDayCalendar(){
        return dayCalendar;
    }

    public int getRegisteredHours(){
        return  registeredHours;
    }

    public void addHours(int hours){
        registeredHours+=registeredHours;
    }
}
