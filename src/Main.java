/**
 * Create by hieuduong on 11/13/17
 *
 * CSC 201 - Assignment 12
 * Problem 12.6:
 *
 * (NumberFormatException) Listing 6.8 implements the hex2Dec(String
 * hexString) method, which converts a hex string into a decimal number.
 * Implement the hex2Dec method to throw a NumberFormatException if the
 * string is not a hex string.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //Create scanner object
        Scanner keyboard = new Scanner(System.in);

        //Get input from user
        System.out.println("Enter a hex number: ");
        String hex = keyboard.nextLine();

        //Print out the hex result
        System.out.println("The decimal value for hex number is "+convertToHex(hex.toUpperCase()));
    }

    /**
     * Convert to Hex method
     * @param hex
     * @return
     * @throws NumberFormatException
     */
    private static int convertToHex(String hex) throws NumberFormatException {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            if(indexOfHex(hexChar) == -1){
                throw new NumberFormatException(hexChar + " is not a hex");
            }
            else {
                decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
            }
        }
        return decimalValue;
    }

    /**
     * Get value of hex char
     * @param ch
     * @return
     */
    private static int hexCharToDecimal(char ch) {
        if(ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else // ch is '0', '1', ..., or '9'
            return ch - '0';

    }

    /**
     * Check whether hex char is valid
     * Hex chars only from 0 to 9, A to F (Capitalized)
     * @param ch
     * @return
     */
    private static int indexOfHex(char ch){
        int index = -1;
        String digits = "0123456789ABCDEF";
        index = digits.indexOf(ch);
        return index;
    }
}