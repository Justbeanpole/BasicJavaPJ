package studentmanagement.function;

import java.util.Scanner;

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
        System.out.print("Enter : ");
        String input = sc.nextLine();
        int result = isInteger(input, min, max);
        if(result == -1){
            System.out.println("[ERROR] Invalid Input, Try again");
            result = getInput(min, max);
        }
        return result;
    }
}