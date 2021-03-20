
/**
 *
 *  Introduction to Java Programming - Programming Exercise 12.8
 *
 *
 *  @author Mustafa Arinmis
 *  @since 06.11.2020
 * */

public class Main {
   
    public static void main(String[] args) throws Exception{
        System.out.println(hexToDecimal("F1S"));
    }
    
    public static int hexToDecimal(String hex) throws HexFormatException {
        if(isHex(hex))
            throw new HexFormatException(hex + "is not hexadecimal");
        
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    
    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else // ch is '0', '1', ..., or '9'
            return ch - '0';
    }
    public static boolean isHex(String str) {

        for(int i=0; i<str.length(); i++) {
            if((!( (str.charAt(i) >= '0' && str.charAt(i) <= '9') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'F'))))
                return false;
        }

        return true;
    }


}

class HexFormatException extends Exception {
    public HexFormatException(){}

    public HexFormatException(String message) {
        super(message);
    }
}