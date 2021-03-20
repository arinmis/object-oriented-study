import java.util.ArrayList;

/**
 *
 *  Introduction to Java Programming - 10.27
 *
 *  @author Mustafa Arinmis
 *  @since 14.08.2020
 *
 * */
public class Workout {
    public static void main(String[] args) {


        MyStringBuilder1 str = new MyStringBuilder1("Mustafa");
        System.out.println(str.append(new MyStringBuilder1(" Arınmış")));
        System.out.println(str.append(10));
        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.toLowerCase());
        System.out.println(str.substring(3, 7));



    }
}

class MyStringBuilder1 {

    private ArrayList<Character> chars;

    public MyStringBuilder1(String str) {
        chars = new ArrayList<Character>();

        for( char chr : str.toCharArray()) {
            this.chars.add(chr);
        }

    }

    public MyStringBuilder1(char[] chars) {
        this.chars = new ArrayList<Character>();
        for( char chr:chars) {
            this.chars.add(chr);
        }
    }

    public MyStringBuilder1 append(MyStringBuilder1 s) {
        ArrayList<Character> temp = new ArrayList<Character>();

        for(int k=0; k<this.getChars().size(); k++) {
            temp.add(this.chars.get(k));
        }

        for(char chr: s.getChars())
            temp.add(chr);


        char[] temp2 = new char[temp.size()];
        for(int i=0; i<temp.size(); i++ ) {
            temp2[i] = temp.get(i);
        }
        return new MyStringBuilder1(temp2);
    }

    public MyStringBuilder1 append(int i) {
        ArrayList<Character> temp = new ArrayList<Character>();

        for(int k=0; k<this.chars.size(); k++)
            temp.add(this.chars.get(k));

        String num = String.valueOf(i);

        for(int j=0; j<num.length(); j++)
            temp.add(num.charAt(j));


        char[] temp2 = new char[temp.size()];
        for(int j=0; j<temp.size(); j++ ) {
            temp2[j] = temp.get(j);
        }
        return new MyStringBuilder1(temp2);
    }

    public int length() {
        return this.chars.size();
    }

    public char charAt(int index) {
        return this.chars.get(index);
    }
    //looping through ArrayList with foreach
    public MyStringBuilder1 toLowerCase() {
        ArrayList<Character> temp = this.chars;
        for(int i=0; i<temp.size(); i++) {
            temp.set(i, Character.toLowerCase(temp.get(i)));
        }

        char[] temp2 = new char[temp.size()];
        for(int i=0; i<temp.size(); i++ ) {
            temp2[i] = temp.get(i);
        }
        return new MyStringBuilder1(temp2);

    }

    public MyStringBuilder1 substring(int begin, int end) {
        ArrayList<Character> temp = new ArrayList<Character>();


        for(int j=begin; j<end; j++) {
            temp.add(this.chars.get(j));
        }

        char[] temp2 = new char[temp.size()];
        for(int i=0; i<temp.size(); i++ ) {
            temp2[i] = temp.get(i);
        }
        return new MyStringBuilder1(temp2);

    }

    public String toString() {
        return String.valueOf(this.chars);
    }


    public ArrayList<Character> getChars() {
        return this.chars;
    }






}



