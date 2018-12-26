package com.vendingmachine.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class UserIO {

    public static Scanner scanner = new Scanner(System.in);
    
    public void print(String msg) {
        System.out.println(msg);
    }
    
    public BigDecimal readMoney(String prompt){
        System.out.println(prompt);
        String returnBDString;
        BigDecimal returnBD;
        while(true) {
            returnBDString = scanner.next();
            if(validEntryBigDecimal(returnBDString)) {
                returnBD = new BigDecimal(returnBDString);
                returnBD = returnBD.setScale(2, RoundingMode.HALF_EVEN);
                break;
            }
        }
        return returnBD;
    }
    
    public int readInt(String prompt) {
        System.out.println(prompt);
        String returnIntString;
        int returnInt;
        while (true) {
            returnIntString = scanner.next();
            if (validEntry(returnIntString)) {
                returnInt = Integer.parseInt(returnIntString);
                break;
            }
        }
        return returnInt;
    }
    
    public int readInt(String prompt, long min, long max) {
        System.out.println(prompt);
        String returnIntString;
        int returnInt;
        while (true) {
            returnIntString = scanner.next();
            if (validEntry(returnIntString)) {
                returnInt = Integer.parseInt(returnIntString);
                if (returnInt >= min && returnInt <= max) {
                    break;
                } else {
                    System.out.format("%d is not a number between %d and %d. Try again.%n", returnInt, min, max);
                }
            }
        }
        return returnInt;
    }
        public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }

    public static boolean validEntry(String num) {
        try {
            int i = Integer.parseInt(num);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("That is not a valid entry. Try again.");
            return false;
        }
    }
    
    public static boolean validEntryBigDecimal(String num) {
        try {
            BigDecimal i = new BigDecimal(num);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("That is not a valid entry. Try again.");
            return false;
        }
    }
}
