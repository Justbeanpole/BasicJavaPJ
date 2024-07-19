package studentmanagement.service;

import studentmanagement.view.ViewPrinter;

import java.util.Scanner;
import java.util.regex.Pattern;
import static studentmanagement.constants.Constants.*;

public class InputValidator {

    private InputValidator() {}

    public static int isInteger(String input, int min, int max) {
        try{
            int temp = Integer.parseInt(input);
            if(temp >= min && temp <= max){
                return temp;
            }
            else{
                return -1;
            }
        }
        catch(Exception e) {
            return -1;
        }
    }

    public static int getInput(int min, int max){
        Scanner sc = new Scanner(System.in);
        ViewPrinter view = new ViewPrinter();
        view.printEnter();
        int temp = isInteger(sc.nextLine(), min, max);
        if(temp == -1) {
            view.printInvalidInput();
            getInput(min, max);
        };
        return temp;
    }

    public static String inputName() {
        Scanner sc = new Scanner(System.in);
        ViewPrinter view = new ViewPrinter();
        view.printEnter();
        String name = sc.nextLine();
        if (!Pattern.matches(ONLY_ENG_KOR, name.trim().toLowerCase())) {
            view.printInvalidInput();
            name = inputName();
        }
        return name;
    }
}