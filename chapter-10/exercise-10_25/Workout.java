import java.util.Scanner;
/**
 *
 *  Introduction to Java Programming - 10.25
 *
 *  @author Mustafa Arinmis
 *  @since 13.08.2020
 *
 * */
public class Workout {
    public static void main(String[] args) {
        String[] strArr = split("a?b?gf#e", "[?#]");
        for(String str:strArr)
            System.out.print(str + " ");
    }

    public static String[] split(String str, String regex) {
        String[] regexArray;
        if (regex.charAt(0) != '[') {
            regexArray = new String[1];
            regexArray[0] = regex;
        } else {
            regexArray = new String[regex.length() - 2];
            int j=0;
            for (int i = 1; i < regex.length() - 1; i++)
                regexArray[j++] = regex.substring(i, i + 1);
        }

        int resultArrayLength = 1;
        for (int i = 0; i < str.length(); i++) {
            for (String rgx : regexArray) {
                if (str.substring(i, i + 1).equals(rgx)){
                    resultArrayLength += 2;
                    break;
                }
            }
        }

        String[] resultArray = new String[resultArrayLength];

        int startIdx = 0;
        int i=0;
        for (int j = 0; j < str.length(); j++) {
            for (String rgx:regexArray) {
                if (str.substring(j, j+1).equals(rgx)) {
                    resultArray[i++] = str.substring(startIdx, j);
                    resultArray[i++] = str.substring(j, j+1);
                    startIdx = j+1;
                    }
                }
        }
        resultArray[resultArrayLength-1] = str.substring(startIdx);

        return resultArray;
    }

}

