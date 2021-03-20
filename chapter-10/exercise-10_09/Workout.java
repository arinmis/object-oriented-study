/**
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *
 *  Introduction to Java Programming - 10.9
 * (The Course class) Revise the Course class as follows:
 * The array size is fixed in Listing 10.6. Improve it to automatically increase
 * the array size by creating a new larger array and copying the contents of the
 * current array to it.
 * Implement the dropStudent method.
 * Add a new method named clear() that removes all students from the
 * course.
 *
 * */



import java.util.ArrayList;

public class Workout {
    public static void main(String[] args) {
        Course course = new Course("Programming");

        course.addStudent("Mustafa");
        course.addStudent("Ahmet");
        course.addStudent("Mehmet");
        course.dropStudent("Mehmet");


        String[] students = course.getStudents();
        for(int i=0; i<students.length; i++)
            System.out.println(students[i]);

    }
}

class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;
    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
        if(numberOfStudents % 100 == 0 && numberOfStudents != 0) {
            String[] tempStudent = new String[numberOfStudents + 100];

            for(int i=0; i<numberOfStudents; i++) {
                tempStudent[i] = students[i];
            }

            students = tempStudent;
        }

    }
    public String[] getStudents() {
        return students;
    }
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    public String getCourseName() {
        return courseName;
    }
    public void dropStudent(String student) {
        for (int i=0; i<numberOfStudents; i++) {
            if (students[i] == student)
                students[i] = null;
        }
    }

    public void clear() {
        students = new String[100];
    }
}
