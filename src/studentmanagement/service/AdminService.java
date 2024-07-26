package studentmanagement.service;

import studentmanagement.user.*;
import studentmanagement.view.*;

import static studentmanagement.service.InputValidator.*;
import static studentmanagement.constants.Constants.*;
import static studentmanagement.service.Service.errorOccurred;

import java.util.*;

public class AdminService implements Service {
    Scanner sc = new Scanner(System.in);
    //ViewPrinter 생성
    AdminViewPrinter view = new AdminViewPrinter();

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
    public void selectFunction(User user) {
        while (true) {
            view.printMenu();
            int input = getInput(0, 4);
            switch (input) {
                case 0 -> {
                    view.printExit();
                    return;
                }
                case 1 -> manageStudent();//학생 관리
                case 2 -> editInfo(user); //Edit info
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
        if (admin.getId().equals(id) && admin.getPw().equals(pw)) {
            view.printSuccess("Login");
            selectFunction(admin);
        } else {
            view.printFailLogin();
        }
    }

    @Override
    public void editInfo(User user) {
        view.printFunctionTitle("edit");
        System.out.println(user.getInfo());
        view.printSelectionModify();
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

    void manageStudent(){
        view.printFunctionTitle("student management");
        while(true){
            view.printStudentManageMenu();
            int id = getInput(0, 4);
            switch (id) {
                case 0 -> {
                    view.printExit();
                    return;
                }
                case 1 -> st.createStudent();
                case 2 -> st.readStudents();
                case 3 -> st.update();
                case 4 -> st.delete();
                default -> errorOccurred();
            }
        }
    }
}
