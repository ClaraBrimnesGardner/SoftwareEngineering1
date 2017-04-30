/**
 * Created by clarabrimnesgardner on 25/04/2017.
 */
public class DayRegistration {
    private DayCalendar dayCalendar;
    private int registeredHalfHours;

    // Constructor
    public DayRegistration(DayCalendar dayCalendar, int registeredHours){
        this.dayCalendar=dayCalendar;
        this.registeredHalfHours=registeredHours;
    }

    // Getter methods
    public DayCalendar getDayCalendar(){
        return dayCalendar;
    }

    public int getRegisteredHalfHours(){
        return  registeredHalfHours;
    }

    public void addHours(int halfHours){
        registeredHalfHours+=registeredHalfHours;
    }
}
