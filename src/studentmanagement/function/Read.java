package studentmanagement.function;

import studentmanagement.student.Student;
import java.util.Collections;
import java.util.Comparator;

public class Read implements Function {
    @Override
    public void printFunction() {
        System.out.println("READ!");
    }

    @Override
    public void run() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getTotal() - o1.getTotal();
            }
        });
        if(!students.isEmpty()) {
            for(Student student : students) {
                student.printStudentInfo();
            }
        }
        else{
            System.out.println("No students found");
        }
        System.out.println();
    }
}
