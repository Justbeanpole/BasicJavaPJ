package studentmanagement.service;

import studentmanagement.user.Admin;
import studentmanagement.user.User;
import studentmanagement.view.ViewPrinter;
import java.util.Scanner;

public interface Service {
    StudentManagement st = StudentManagement.getInstance();
    Scanner sc = new Scanner(System.in);
    ViewPrinter view = new ViewPrinter();
    Admin admin = new Admin();
    void loginMenu();
    void selectFunction(User user);
    void editInfo(User user);

    //Login
    void signIn();
    static void errorOccurred(){
        view.printError();
        System.exit(0);
    }

}
