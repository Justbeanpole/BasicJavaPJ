package studentmanagement.function;

import studentmanagement.student.Student;

import java.util.ArrayList;

public interface Function {
    ArrayList<Student> students = new ArrayList<>();
    void printFunction();
    void run();
}
