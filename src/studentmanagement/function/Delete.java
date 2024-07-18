package studentmanagement.function;

import studentmanagement.student.Student;

import static studentmanagement.function.InputValidator.getInput;

public class Delete implements Function {
    @Override
    public void printFunction() {
        System.out.println("DELETE!");
        System.out.println("Please enter your student number to delete");
    }

    @Override
    public void run() {
        int stdNum = getInput(10000000, 99999999);
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentNumber() == stdNum) {
                students.remove(student);
                System.out.println("Deleted!!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not Exist");
        };
        System.out.println();
    }
}
