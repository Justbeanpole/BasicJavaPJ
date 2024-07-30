package studentmanagement.service;

import studentmanagement.user.Teacher;
import studentmanagement.user.User;
import studentmanagement.view.TeacherViewPrinter;

import static studentmanagement.constants.Constants.*;
import static studentmanagement.service.InputValidator.getInput;
import static studentmanagement.service.InputValidator.getInputString;

public class TeacherService implements Service{
    TeacherViewPrinter view = new TeacherViewPrinter();
    AdminService ads = new AdminService();
    @Override
    public void loginMenu() {
        view.printTitle();
        while (true) {
            view.printLoginSelect();
            int input = getInput(0, 2);
            switch (input) {
                case 0 -> {
                    view.printExit();
                    return;
                }
                case 1 -> register();
                case 2 -> signIn();
                default -> errorOccurred();
            }
        }
    }

    @Override
    public void selectFunction(User user) {
        while (true) {
            view.printMenu();
            int input = getInput(0, 3);
            switch (input) {
                case 0 -> {
                    view.printExit();
                    return;
                }
                case 1 -> myInfo((Teacher) user);
                case 2 -> editInfo(user); //Update
                case 3 -> ads.manageStudent();
                default -> errorOccurred();
            }
        }
    }

    @Override
    public void editInfo(User user) {
        view.printFunctionTitle("edit");
        view.printEditTeacher();
        int id = getInput(0, 3);
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
            case 3 -> {
                view.printInputSubject();
                ((Teacher)user).setSubject(getInputString(SUBJECT_NAME));
                view.printSuccess("Update");
            }
            default -> errorOccurred();
        }
    }

    @Override
    public void signIn() {
        view.printFunctionTitle("login");
        view.printInputId();
        String id = sc.nextLine();
        view.printInputPw();
        String pw = sc.nextLine();
        Teacher teacher = th.findUser(id);
        if (teacher != null && teacher.getPw().equals(pw)) {
            view.printSuccess("Login");
            selectFunction(teacher);
        }
        else {
            view.printFailLogin();
        }
    }

    public void register() {
        view.printFunctionTitle("register");
        th.create();
        view.printSuccess("Register");
    }

    void myInfo(Teacher teacher){
        view.printFunctionTitle("my info");
        System.out.println("   ID    : " + teacher.getId());
        System.out.println("   PW    : " + teacher.getPw());
        System.out.println("  Name   : " + teacher.getName());
        System.out.println(" Subject : " + teacher.getSubject());
    }
}
