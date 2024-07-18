package studentmanagement.function;

import studentmanagement.student.Student;

import static studentmanagement.function.InputValidator.getInput;

public class Search implements Function {
    @Override
    public void printFunction() {
        System.out.println("Search!");
        System.out.println("Please enter your student number to search for");
    }

    @Override
    public void run() {
        int stdNum = getInput(10000000, 99999999);
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentNumber() == stdNum) {
                System.out.println("Found!!");
                student.printStudentInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not Exist");
        }
        System.out.println();
    }
}
