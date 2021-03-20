/**
 *  Programming Exercise 13.13
 *
 *  (Enable the Course class cloneable) Rewrite the Course class in Listing 10.6
 *  to add a clone method to perform a deep copy on the students field.
 *
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */
 
import java.util.Arrays;

public class Exercise13_13{
    public static void main(String[] args) {
        //test program
        Course course1 = new Course("DS");
        course1.addStudent("mustafa");
        course1.addStudent("ayse");

        Course course2 = null;
        try {
            course2 = (Course)course1.clone();
        }
        catch (CloneNotSupportedException ex)
        {
            ex.printStackTrace();
        }

        course2.addStudent("ahmet");
        System.out.println(Arrays.toString(course1.getStudents()));
        System.out.println(Arrays.toString(course2.getStudents()));
    }
}


class Course implements Cloneable{
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

    // added new for cloning purpose
    public void setStudents(String[] students) {
        this.students = students;
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

    @Override
    public Object clone() throws CloneNotSupportedException{
        //shallow cloning
        Object cloneCourse = super.clone();

        // deep cloning part
        String[] cloneStudents = new String[students.length];
        for(int i=0; i<numberOfStudents; i++) {
            cloneStudents[i] = new String(this.students[i]);
        }
        ((Course)cloneCourse).setStudents(cloneStudents);

        return cloneCourse;
    }
}
