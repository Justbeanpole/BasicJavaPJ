package studentmanagement.function;

import studentmanagement.student.Student;

import java.util.InputMismatchException;

import static studentmanagement.function.InputValidator.getInput;

public class Update extends Get {
    @Override
    public void printFunction() {
        System.out.println("UPDATE!");
    }

    @Override
    public void run() {
        System.out.println("Please enter your student number to modify");
        int stdNum = getInput(10000000, 99999999);
        while(findStudent(stdNum) == null){
            System.out.println("Enter another student number");
            stdNum = getInput(10000000, 99999999);
        }
        chooseModifySection(findStudent(stdNum));
        System.out.println("Student Updated!");
        System.out.println();
    }

    void chooseModifySection(Student std){
        System.out.println("Choose the section you want to modify");
        System.out.println("1.Name 2.KoreanScore 3.MathScore 4.EnglishScore");
        int id = getInput(1,4);
        switch (id) {
            case 1:{
                System.out.println("Enter a name to change");
                String changeName = getStudentName();
                std.setName(changeName);
                break;
            }
            case 2:{
                System.out.println("Enter a KoreanScore to change");
                int changeKoreanScore = getInput(0,100);
                std.setKoreanScore(changeKoreanScore);
                break;
            }
            case 3:{
                System.out.println("Enter a MathScore to change");
                int changeMathScore = getInput(0,100);
                std.setMathScore(changeMathScore);
                break;
            }
            case 4:{
                System.out.println("Enter a EnglishScore to change");
                int changeEnglishScore = getInput(0,100);
                std.setEnglishScore(changeEnglishScore);
                break;
            }
            default:{
                throw new InputMismatchException();
            }
        }
    }
    Student findStudent(int stdNum){
        for (Student student : students) {
            if (student.getStudentNumber() == stdNum) {
                return student;
            }
        }
        System.out.println("Not Exist");
        return null;
    }

}
