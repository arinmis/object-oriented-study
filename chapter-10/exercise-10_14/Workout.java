import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 *  Introduction to Java Programming - 10.14
 *
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *  
 * */


public class Workout {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(34355555133101L);
        myDate.setDate(561555550000l);
        System.out.println("Day: " + myDate.getDay());
        System.out.println("Month: " + myDate.getMonth());
        System.out.println("Year: " + myDate.getYear());
    }
}

class MyDate{
    private long year;
    private long month;
    private long day;

    public MyDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH);
        this.day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public MyDate() {
        LocalDate date = LocalDate.now();
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public long getYear() {
        return year;
    }

    public long getMonth() {
        return month;
    }

    public long getDay() {
        return day;
    }

}
