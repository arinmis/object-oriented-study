import java.math.BigInteger;

/**
 *
 *  Introduction to Java Programming - 10.23
 *
 *  @author Mustafa Arinmis
 *  @since 04.08.2020
 *
 * */

public class Workout {
    public static void main(String[] args) {

        MyString2 str = new MyString2("Book");

        System.out.println(str.compare("book"));
        System.out.println(str.compare("Bookkk"));

        String subStr = new String(str.substring(2).toChars());
        // It should print "ok"
        System.out.println(subStr);

        System.out.println(new String(MyString2.valueOf(false).toChars()));

    }
}

class MyString2 {
    private char[] chars;

    public char[] getChars() {
        return this.chars;
    }

    public MyString2(String str) {
        this.chars = str.toCharArray();
    }

    public int compare(String str) {

        int iterator = Math.min(str.length(), this.chars.length);

        for (int i = 0; i < iterator; i++) {
            if (this.chars[i] > str.toCharArray()[i])
                return this.chars[i] - str.toCharArray()[i];
            else if (this.chars[i] < str.toCharArray()[i])
                return this.chars[i] - str.toCharArray()[i];
        }

        if (this.chars.length > str.length())
            return 1;
        else if (this.chars.length < str.length())
            return -1;

        return 0;
    }

    public MyString2 substring(int begin) {
        int len = this.chars.length - begin;
        char[] temp = new char[len];

        for (int i = 0, j = begin; i < len; i++, j++) {
            temp[i] = chars[j];
        }

        return new MyString2(new String(temp));

    }

    public MyString2 toUpperCase() {
        char[] temp = this.getChars();

        for(int i=0; i< this.chars.length; i++) {
            temp[i] = Character.toLowerCase(temp[i]);
        }

        return new MyString2(new String(temp));
    }

    public char[] toChars() {
        return this.chars;
    }

    public static MyString2 valueOf(boolean b) {
        String str = b ? "true" : "false";
        return new MyString2(str);
    }
}
