package studentmanagement.service;

import studentmanagement.student.Student;
import studentmanagement.view.ViewPrinter;

import java.util.*;

import static studentmanagement.constants.Constants.*;
import static studentmanagement.service.InputValidator.*;

public class ManagementService {
    //SingleTon
    private ManagementService(){}
    private static ManagementService managementService;
    public static ManagementService getInstance(){
        if(managementService == null)
            return new ManagementService();
        return managementService;
    }

    //학생 정보 저장 리스트
    ArrayList<Student> students = new ArrayList<>();
    //ViewPrinter 생성
    ViewPrinter view = new ViewPrinter();


    public void input(){
        view.printFuctionTitle("get");
        view.printInputNumber();
        int num = getInput(ST_NUMBER_MIN, ST_NUMBER_MAX);
        while(findStudent(num) != null){
            view.printisDuplicated();
            num = getInput(ST_NUMBER_MIN, ST_NUMBER_MAX);
        }
        view.printInputName();
        String name = inputName();
        view.printInputScore("Korean");
        int kScore = getInput(SCORE_MIN, SCORE_MAX);
        view.printInputScore("Math");
        int mScore = getInput(SCORE_MIN, SCORE_MAX);
        view.printInputScore("English");
        int eScore = getInput(SCORE_MIN, SCORE_MAX);

        addList(new Student(num, name, kScore, mScore, eScore));
    }

    //read
    public void read(){
        view.printFuctionTitle("read");
        //오름차순 정렬
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getTotal() - o1.getTotal();
            }
        });
        //출력
        if(!students.isEmpty()) {
            for(Student student : students) {
                view.printStudentInfo(student);
            }
        }
        else{
            view.printNoExist();
        }
    }

    //Search
    public void search(){
        view.printFuctionTitle("search");
        if(findStudent(getInput(ST_NUMBER_MIN, ST_NUMBER_MAX)) != null){
            view.printSuccessFuction("Search");
            view.printStudentInfo(findStudent(getInput(ST_NUMBER_MIN, ST_NUMBER_MAX)));
        }
        else{
            view.printNoExist();
        }
    }
    //Delete
    public void delete(){
        view.printFuctionTitle("delete");
        if(findStudent(getInput(ST_NUMBER_MIN, ST_NUMBER_MAX)) != null){
            view.printSuccessFuction("Delete");
            students.remove(findStudent(getInput(ST_NUMBER_MIN, ST_NUMBER_MAX)));
        }
        else{
            view.printNoExist();
        }
    }
    //Update
    public void update(){
        view.printFuctionTitle("update");
        view.printSelectionModify();
        int stdNum = getInput(ST_NUMBER_MIN, ST_NUMBER_MAX);
        while(findStudent(stdNum) == null){
            view.printNoExist();
            stdNum = getInput(ST_NUMBER_MIN, ST_NUMBER_MAX);
        }
        chooseModifySection(findStudent(stdNum));
        System.out.println();
    }
    //Exit
    public void exitSystem(){
        view.printExit();
        System.exit(0);
    }
    //Error ShutDown
    public void errorSystem(){
        view.printError();
        view.printExit();
        System.exit(0);
    }
    //수정 부분 선택 후 수정
    void chooseModifySection(Student std){
        view.printSelectionModify();
        int id = getInput(0,4);
        switch (id) {
            case 0: {
                break;
            }
            case 1:{
                view.printInputName();
                String changeName = inputName();
                std.setName(changeName);
                view.printSuccessFuction("Update");
                break;
            }
            case 2:{
                view.printInputScore("Korean");
                std.setKoreanScore(getInput(SCORE_MIN,SCORE_MAX));
                view.printSuccessFuction("Update");
                break;
            }
            case 3:{
                view.printInputScore("Math");
                std.setMathScore(getInput(SCORE_MIN,SCORE_MAX));
                view.printSuccessFuction("Update");
                break;
            }
            case 4:{
                view.printInputScore("English");
                std.setEnglishScore(getInput(SCORE_MIN,SCORE_MAX));
                view.printSuccessFuction("Update");
                break;
            }
            default:{
                System.out.println("ERROR");;
            }
        }
    }

    //리스트 추가
    public void addList(Student student){
        students.add(student);
    }

    Student findStudent(int studentNum) {
        for (Student student : students) {
            if (student.getStudentNumber() == studentNum) {
                return student;
            }
        }
        return null;
    }
}
