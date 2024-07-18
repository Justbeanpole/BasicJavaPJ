package studentmanagement.function;

import studentmanagement.student.Student;

import java.util.Scanner;
import java.util.regex.Pattern;

import static studentmanagement.function.InputValidator.*;

public class Get implements Function {
    Scanner sc = new Scanner(System.in);

    @Override
    public void printFunction() {
        System.out.println("GET!");
    }

    @Override
    public void run() {
        System.out.println("Enter the number of Student");
        int studentNum = getStudentNumber();
        System.out.println();
        System.out.println("Enter the name of Student");
        String studentName = getStudentName();
        System.out.println();
        System.out.println("Enter the Korean Score");
        int koreanScore = getInput(0, 100);
        System.out.println();
        System.out.println("Enter the Math Score");
        int mathScore = getInput(0, 100);
        System.out.println();
        System.out.println("Enter the English Score");
        int englishScore = getInput(0, 100);
        System.out.println();
        students.add(new Student(studentNum, studentName, koreanScore, mathScore, englishScore));
    }

    int getStudentNumber() {
        int stdNum = getInput(10000000, 99999999);
        for (Student student : students) {
            if (student.getStudentNumber() == stdNum) {
                System.out.println("Student ID already exists. Please enter a different ID.");
                stdNum = getStudentNumber();
            }
        }
        return stdNum;
    }

    String getStudentName() {
        System.out.print("Enter : ");
        String name = sc.nextLine();
        name = name.trim();
        name = name.toLowerCase();
        String ONLY_ENG_KOR = "^[a-z가-힣]*$";
        if (!Pattern.matches(ONLY_ENG_KOR, name)) {
            System.out.println("Only Korean and English characters are allowed.");
            name = getStudentName();
        }
        return name;
    }

}
