package studentmanagement.service;

import studentmanagement.user.Admin;
import studentmanagement.user.User;
import studentmanagement.view.ViewPrinter;
import java.util.Scanner;

public interface Service {
    Scanner sc = new Scanner(System.in);
    ViewPrinter view = new ViewPrinter();
    StudentManagement st = new StudentManagement();
    TeacherManagement th = new TeacherManagement();
    Admin admin = new Admin();

    void loginMenu();
    void selectFunction(User user);
    void editInfo(User user);
    void signIn();

    default void errorOccurred(){
        view.printError();
        System.exit(0);
    }
}
