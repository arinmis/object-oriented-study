import java.util.ArrayList;

/**
 *
 *  Introduction to Java Programming - 10.28
 *
 *  @author Mustafa Arinmis
 *  @since 14.08.2020
 *
 * */
public class Workout {
    public static void main(String[] args) {
        MyStringBuilder2 str = new MyStringBuilder2("Mustafa Arınmış");
        System.out.println(String.valueOf(str.insert(7, new MyStringBuilder2(" J."))));
        System.out.println(str.reverse());
        System.out.println(str.substring(8));
        System.out.println(str.toUpperCase());

    }
}

class MyStringBuilder2 {
    private char[] chars;

    public MyStringBuilder2(char[] chars) {
        this.chars = chars;
    }

    public MyStringBuilder2() {
        this(new char[] {});
    }

    public MyStringBuilder2(String s) {
        this(s.toCharArray());
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s){
        char[] temp = new char[s.getChars().length + this.chars.length];

        for(int i=0, j=0, k=0; i<temp.length; i++ ) {
            // "Mustafa Arınmış"
            if(i<offset || i>=s.getChars().length + offset) {
                temp[i] = this.chars[j++];
            }
            else
                temp[i] = s.getChars()[k++];
        }
        return new MyStringBuilder2(temp);
    }

    public MyStringBuilder2 reverse() {
        char[] temp = new char[this.chars.length];

        for(int i=this.chars.length-1, j=0; i>=0; i--) {
            temp[j++] = this.chars[i];
        }
        return new MyStringBuilder2(temp);

    }

    public MyStringBuilder2 substring(int begin) {
        char[] temp = new char[this.chars.length-begin];
        for(int i=begin, j=0; i<this.chars.length; i++) {
            temp[j++] = this.chars[i];
        }

        return new MyStringBuilder2(temp);
    }

    public MyStringBuilder2 toUpperCase() {

        char[] temp = new char[this.chars.length];
        for(int i=0; i<this.chars.length; i++) {
            temp[i] = Character.toUpperCase(this.chars[i]);
        }

        return new MyStringBuilder2(temp);

    }

    public String toString() {
        return String.valueOf(this.chars);
    }

    public char[] getChars() {
        return this.chars;
    }
}
