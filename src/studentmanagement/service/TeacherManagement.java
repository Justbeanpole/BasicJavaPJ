package studentmanagement.service;

import studentmanagement.constants.Subject;
import studentmanagement.user.Teacher;
import studentmanagement.view.TeacherViewPrinter;

import java.util.ArrayList;

import static studentmanagement.constants.Constants.*;
import static studentmanagement.service.InputValidator.getInput;
import static studentmanagement.service.InputValidator.getInputString;

public class TeacherManagement {
    TeacherViewPrinter view = new TeacherViewPrinter();
    private final ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    //create
    public void create(){
        view.printInputId();
        String id = getInputString(ID_PW_RULE);
        while(findUser(id) != null){
            view.printDuplicated();
            id = getInputString(ID_PW_RULE);
        }
        view.printInputName();
        String name = getInputString(ONLY_ENG_KOR);
        view.printInputSubject();
        String subjectName = getInputString(SUBJECT_NAME);
        Subject subject = Subject.valueOf(subjectName);

        addTeacherList(new Teacher(id,name, subject));
    }

    //read
    public void read() {
        view.printFunctionTitle("read");
        if(teachers.isEmpty()){
            view.printNoExist();
            return;
        }
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getInfo());
        }
    }

    //Update
    public void update() {
        view.printFunctionTitle("update");
        view.printInputId();
        Teacher th = findUser(getInputString(ID_PW_RULE));
        if(th != null) {
            chooseModifySection(th);
            return;
        }
        view.printNoExist();
    }

    //수정 부분 선택 후 수정
    //따로 정의
    void chooseModifySection(Teacher th) {
        view.printEditTeacher();
        int id = getInput(0, 4);
        switch (id) {
            case 0: {
                break;
            }
            case 1: {
                view.printInputName();
                th.setName(getInputString(ONLY_ENG_KOR));
                view.printSuccess("Update");
                break;
            }
            case 2: {
                view.printInputPw();
                th.setPw(getInputString(ID_PW_RULE));
                view.printSuccess("Update");
                break;
            }
            case 3: {
                view.printInputSubject();
                th.setSubject(getInputString(SUBJECT_NAME));
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
        view.printInputId();
        Teacher th = findUser(getInputString(ID_PW_RULE));
        if (th != null) {
            view.printSuccess("Delete");
            teachers.remove(th);
        } else {
            view.printNoExist();
        }
    }

    //리스트 추가
    public void addTeacherList(Teacher teacher) {
        teachers.add(teacher);
    }

    Teacher findUser(String id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null;
    }
}
