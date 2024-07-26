package studentmanagement.service;

import studentmanagement.view.ViewPrinter;

import java.util.Scanner;
import java.util.regex.Pattern;



public class InputValidator {
    private InputValidator() {}
    static ViewPrinter view = new ViewPrinter();
    static Scanner sc = new Scanner(System.in);
    //String input 검정 id,pw,name ---
    public static String validatedInput(String input, String pattern) {
        if (Pattern.matches(pattern, input)) {
            return input;
        }
        return null;
    }

    //Integer input 검정 score, selection
    public static int validatedInputInt(String input, int min, int max) {
        try {
            int temp = Integer.parseInt(input);
            if (temp >= min && temp <= max) {
                return temp;
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getInput(int min, int max) {
        int temp = validatedInputInt(sc.nextLine(), min, max);
        while (temp == -1) {
            view.printInvalidInput();
            temp = validatedInputInt(sc.nextLine(), min, max);
        }
        return temp;
    }

    public static String getInputString(String pattern) {
        String id = validatedInput(sc.nextLine(), pattern);
        while (id == null) {
            view.printInvalidInput();
            id = validatedInput(sc.nextLine(), pattern);
        }
        return id;
    }

}