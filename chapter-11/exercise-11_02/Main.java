import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.2
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */



public class Main {
    public static void main(String[] args) {
        Person person = new Person("Adam", "Heaven",
                "1111", "adam@gmail.com");
        System.out.println(person.toString());

        Student student = new Student("Mustafa", "Tokat", "0545*****3",
                "mustafa_arinmis@outlook.com", "sophomore");
        System.out.println(student.toString());

        Employee employee = new Employee("Worker", "Center Office","10.000");
        System.out.println(employee.toString());

        Faculty faculty = new Faculty("Prof.", "10.00 pm", "4.7");
        System.out.println(faculty.toString());

        Staff staff = new Staff("Officer", "consultant");
        System.out.println(staff.toString());
    }
}

class Person{
    String name;
    String adress;
    String phone;
    String email;

    public Person(String name, String adress, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Class name:  Person class, Person name: " + this.name;
    }
}

class Student extends Person{

    final String status ;


    public Student(String status) {
        this.status = status;
    }

    public Student(String name, String adress, String phone,
                   String email, String status) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.status = status;
    }



    @Override
    public String toString() {
        return "Class name:  Student class, Person name: " + this.name;
    }
}

class Employee extends Person{

    String office;
    String salary;
    MyDate dateHired;

    public Employee() {
        dateHired = new MyDate();
    }

    public Employee(String name, String office, String salary) {
        dateHired = new MyDate();
        this.name = name;
        this.salary = salary;
        this.office = office;
    }

    @Override
    public String toString() {
        return "Class name:  Employee class, Person name: " + this.name;
    }

}

class Faculty extends Person{
    String officeHours;
    String rank;

    public Faculty() {}

    public Faculty(String name, String officeHours, String rank) {
        this.name = name;
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Class name:  Faculty class, Person name: " + this.name;
    }

}

class Staff extends Person{
    String title;

    public Staff() {}

    public Staff(String name, String title) {
        this.name = name;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Class name:  Staff class, Person name: " + this.name;
    }
}


class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate() {

        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

    }

    public MyDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }
}



