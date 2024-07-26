package studentmanagement.service;

import studentmanagement.user.Student;
import studentmanagement.view.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static studentmanagement.constants.Constants.*;
import static studentmanagement.service.InputValidator.*;

public class StudentManagement {
    StudentViewPrinter view = new StudentViewPrinter();

    private ArrayList<Student> students = new ArrayList<Student>();
    //create
    public void createStudent(){
        view.printFunctionTitle("create");
        view.printInputNumber();
        String id = getInputString(STUDENT_NUMBER);
        while(findStudent(id) != null){
            view.printDuplicated();
            id = getInputString(STUDENT_NUMBER);
        }
        view.printInputName();
        String name = getInputString(ONLY_ENG_KOR);
        view.printInputScore("Korean");
        int kscore= getInput(SCORE_MIN,SCORE_MAX);
        view.printInputScore("Math");
        int mscore = getInput(SCORE_MIN,SCORE_MAX);
        view.printInputScore("English");
        int escore = getInput(SCORE_MIN,SCORE_MAX);

        view.printSuccess("Create");
        addStudentList(new Student(id,name,kscore,mscore,escore));
    }

    //read
    public void readStudents() {
        view.printFunctionTitle("read");
        if(students.isEmpty()){
            view.printNoExist();
            return;
        }
        //오름차순 정렬
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getTotal() - o1.getTotal();
            }
        });
        for (Student student : students) {
            System.out.println(student.getInfo());
        }
    }

    //Update
    public void update() {
        view.printFunctionTitle("update");
        view.printInputNumber();
        Student st = findStudent(getInputString(STUDENT_NUMBER));
        if(st != null) {
            chooseModifySection(st);
            return;
        }
        view.printNoExist();
    }

    //수정 부분 선택 후 수정
    void chooseModifySection(Student std) {
        view.printSelectionModify();
        int id = getInput(0, 4);
        switch (id) {
            case 0: {
                break;
            }
            case 1: {
                view.printInputName();
                std.setName(getInputString(ONLY_ENG_KOR));
                view.printSuccess("Update");
                break;
            }
            case 2: {
                view.printInputScore("Korean");
                std.setKoreanScore(getInput(SCORE_MIN, SCORE_MAX));
                view.printSuccess("Update");
                break;
            }
            case 3: {
                view.printInputScore("Math");
                std.setMathScore(getInput(SCORE_MIN, SCORE_MAX));
                view.printSuccess("Update");
                break;
            }
            case 4: {
                view.printInputScore("English");
                std.setEnglishScore(getInput(SCORE_MIN, SCORE_MAX));
                view.printSuccess("Update");
                break;
            }
            default: {
                System.out.println("ERROR");
            }
        }
    }
    //Delete
    public void delete() {
        view.printFunctionTitle("delete");
        view.printInputNumber();
        Student st = findStudent(getInputString(STUDENT_NUMBER));
        if (st != null) {
            view.printSuccess("Delete");
            students.remove(st);
        } else {
            view.printNoExist();
        }
    }

    //리스트 추가
    public void addStudentList(Student student) {
        students.add(student);
    }

    Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}
