import java.math.BigInteger;

/**
 *
 *  Introduction to Java Programming - 10.22
 *  
 *  Rewriting String Class
 *
 *  @author Mustafa Arinmis
 *  @since 04.08.2020
 *
 * */



public class Workout {
    public static void main(String[] args) {
        char[] name = {'M', 'u', 's', 't', 'A', 'f', 'A'};
        MyString1 str = new MyString1(name);
        str = str.toLowerCase();
        str = str.substring(3, 6);
        for(char c : str.getChars())
            System.out.print(c);
        System.out.println();

        MyString1 str2 = new MyString1(new char[] {'t', 'a', 'f'});
        System.out.println(str.equals(str2));

        MyString1 str3 = MyString1.valueOf(56789);
        for(char c : str3.getChars())
            System.out.print((int)c);


    }
}

class MyString1{

    private char[] chars;

    public MyString1(char[] chars) {
        this.chars = chars;
    }

    public char charAt(int index) {
        return chars[index];
    }

    public int length() {
        return chars.length;
    }

    public MyString1 substring(int begin, int end) {
        char[] temp = new char[end-begin];

        for(int i=0,  j=begin; i<end-begin; i++, j++) {
            temp[i] = this.chars[j];
        }

        return new MyString1(temp);
    }

    public MyString1 toLowerCase() {
        char[] temp = new char[this.length()];

        for(int i=0; i<this.length(); i++) {
            temp[i] = Character.toLowerCase(this.getChars()[i]);
        }

        return new MyString1(temp);

    }

    public boolean equals(MyString1 myString) {
        if ( this.length() != myString.length() )
            return false;

        for(int i=0; i<this.length(); i++) {
            if(this.chars[i] != myString.getChars()[i])
                return false;
        }
        return true;
    }


    public static MyString1 valueOf(int number) {
        int tempNum = number;
        int digit = 0;
        while(true) {
            digit++;
            tempNum /= 10;
            if(tempNum == 0)
                break;
        }

        char[] temp = new char[digit];
        for(int i=0, j=digit-1; i<digit; i++, j--) {
            temp[j] = (char)(number / (int)Math.pow(10, i) % 10);
        }
        return new MyString1(temp);
    }

    public char[] getChars() {
        return this.chars;
    }
}