import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.6
 *
 *  Note: I used ArrayList<Double> and GregorianCalender objects
 *  intstead of Loan, Circle obejects
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */


public class Main {
    public static void main(String[] args) {
        //Creating general array list
        ArrayList<Object> list = new ArrayList<>();

        // Element object of general list
        ArrayList<Double> doubleList = new ArrayList<>(Arrays.asList(new Double[] {1.2, 3.4, 6.7}));
        Date date = new Date();
        String str = "Mustafa";
        GregorianCalendar calendar = new GregorianCalendar();

        list.add(doubleList);
        list.add(date);
        list.add(str);
        list.add(calendar);

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

    }
}
