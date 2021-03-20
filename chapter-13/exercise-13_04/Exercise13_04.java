/**
 *  Programming Exercise 13.4
 *
 *  (Display calendars) Rewrite the PrintCalendar class in Listing 6.12 to display
 *  a calendar for a specified month using the Calendar and GregorianCalendar
 *  classes. Your program receives the month and year from the command line. For
 *  example:
 *
 *  java Exercise13_04 5 2016
 *
 *  @author Mustafa Arinmis
 *  @since 23.12.2020
 * */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exercise13_04{
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        readInput(args, calendar);
        printMonth(calendar);
    }

    public static void readInput(String[] args, Calendar calendar) {
        if(args.length == 1) { // year is given
            // just month is given
            calendar.set(Calendar.MONTH, Integer.valueOf(args[0] ) - 1); //calendar months starts from 0
        }else if(args.length == 2) {;
            calendar.set(Calendar.MONTH, Calendar.APRIL);calendar.set(Calendar.YEAR, Integer.valueOf(args[1]));
        }
        else{
            System.out.println("Usage: java Exercise13_04 5 2016");
        }

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }


    public static String getMonthName(int monthNum) {
        switch (monthNum) {
            case 0:
                return "Jan";
            case 1:
                return "Feb";
            case 2:
                return "Mar";
            case 3:
                return "Apr";
            case 4:
                return "May";
            case 5:
                return "Jun";
            case 6:
                return "Jul";
            case 7:
                return "Aug";
            case 8:
                return "Sep";
            case 9:
                return "Oct";
            case 10:
                return "Nov";
            case 11:
                return "Dec";
            default:
                return "Error";
        }
    }

    public static void printMonth(Calendar calendar) {

        //print month and year
        System.out.printf("        %s, %d\n", getMonthName(calendar.get(Calendar.MONTH)), calendar.get(calendar.YEAR));

        //print bar and days name
        System.out.println("---------------------------");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        //print days
        printDays(calendar);
    }

    public static void printDays(Calendar calendar) {
        //get month length
        int lenOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //get first day
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        String daysOfCal = addSpace((firstDay-1) * 4);
        for(int i=0; i<lenOfMonth; i++) {
            int spaceAmount = (i+1) < 10 ? 2:1;
            daysOfCal += addSpace(spaceAmount) + (i+1) + " " ;
            if((i + firstDay) % 7 == 0) {
                daysOfCal += "\n";
            }
        }
        System.out.println(daysOfCal);
    }

    public static String addSpace(int amount) {
        String result = "";
        for(int i=0; i<amount; i++)
            result += " ";
        return result;
    }

}
