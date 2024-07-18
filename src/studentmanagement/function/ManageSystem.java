package studentmanagement.function;

import studentmanagement.student.Student;

import java.util.*;
import java.util.regex.Pattern;

import static studentmanagement.function.InputValidator.*;

public class ManageSystem {
    //SingleTon
    private ManageSystem(){}
    static ManageSystem manageSystem = null;
    public static ManageSystem getInstance(){
        if(manageSystem == null)
            return new ManageSystem();
        return manageSystem;
    }
    //학생 정보 저장 리스트
    ArrayList<Student> students = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    //get
    public void getFuc(){

//        int studentNum = getStudentNumber();
        System.out.println();

        String studentName = getStudentName();
        System.out.println();

        int koreanScore = getInput(0, 100);
        System.out.println();

        int mathScore = getInput(0, 100);
        System.out.println();

        int englishScore = getInput(0, 100);
        System.out.println();
//        students.add(new Student(studentNum, studentName, koreanScore, mathScore, englishScore));
    }
    boolean findStudent(int studentNum) {
        int stdNum = studentNum;
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentNumber() == stdNum) {
                found = true;
                return found;
            }
        }
        return found;
    }
    String getStudentName() {

        String name = sc.nextLine();
        name = name.trim();
        name = name.toLowerCase();
        String ONLY_ENG_KOR = "^[a-z가-힣]*$";
        if (!Pattern.matches(ONLY_ENG_KOR, name)) {

            name = getStudentName();
        }
        return name;
    }

    //read
    public void readFuc(){
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

    //search
    public void searchFuc(){
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
            System.out.println("No Exist");
        }
        System.out.println();
    }

    public void deleteFuc(){
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

//    public void updateFuc(){
//
//        int stdNum = getInput(10000000, 99999999);
//        while(findStudent(stdNum) == null){
//            System.out.println("Enter another student number");
//            stdNum = getInput(10000000, 99999999);
//        }
//        chooseModifySection(findStudent(stdNum));
//        System.out.println("Student Updated!");
//        System.out.println();
//    }
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
//    Student findStudent(int stdNum){
//        for (Student student : students) {
//            if (student.getStudentNumber() == stdNum) {
//                return student;
//            }
//        }
//        System.out.println("Not Exist");
//        return null;
//    }
}
