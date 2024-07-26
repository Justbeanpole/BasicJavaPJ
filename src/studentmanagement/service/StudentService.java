package studentmanagement.service;

import studentmanagement.user.*;
import studentmanagement.view.*;

import static studentmanagement.constants.Constants.*;
import static studentmanagement.service.InputValidator.*;


public class StudentService implements Service {
    StudentViewPrinter view = new StudentViewPrinter();

    @Override
    public void loginMenu() {
        view.printTitle();
        while (true) {
            view.printLoginSelect();
            int input = getInput(0, 1);
            switch (input) {
                case 0 -> {
                    view.printExit();
                    return;
                }
                case 1 -> signIn();
                default -> errorOccurred();
            }
        }
    }

    @Override
    public void signIn() {
        view.printFunctionTitle("login");
        view.printInputId();
        String id = sc.nextLine();
        view.printInputPw();
        String pw = sc.nextLine();
        Student student = st.findStudent(id);
        if (student != null && student.getPw().equals(pw)) {
            view.printSuccess("Login");
            selectFunction(student);
        }
        else {
            view.printFailLogin();
        }
    }

    @Override
    public void selectFunction(User user) {
        while (true) {
            view.printMenu();
            int input = getInput(0, 4);
            switch (input) {
                case 0 -> {
                    view.printExit();
                    return;
                }
                case 1 -> myInfo((Student) user);
                case 2 -> editInfo(user); //Update
                default -> errorOccurred();
            }
        }
    }

    void myInfo(Student student){
        view.printFunctionTitle("my info");
        System.out.println("     ID       : " + student.getId());
        System.out.println("     PW       : " + student.getPw());
        System.out.println("    Name      : " + student.getName());
        System.out.println("Korean Score  : " + student.getKoreanScore());
        System.out.println(" Math Score   : " + student.getMathScore());
        System.out.println("English Score : " + student.getEnglishScore());
        System.out.println(" Total Score  : " + student.getTotal());
        System.out.printf ("Score Average : %.1f\n",student.getAverage());
    }

    public void editInfo(User user){
        view.printFunctionTitle("edit");
        view.superSelectionModify();
        int id = getInput(0, 2);
        switch (id) {
            case 0 -> view.printExit();
            case 1 -> {
                view.printInputName();
                user.setName(getInputString(ONLY_ENG_KOR));
                view.printSuccess("Update");
            }
            case 2 -> {
                view.printInputPw();
                user.setPw(getInputString(ID_PW_RULE));
                view.printSuccess("Update");
            }
            default -> errorOccurred();
        }
    }
}
