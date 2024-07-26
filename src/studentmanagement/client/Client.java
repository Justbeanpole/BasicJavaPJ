package studentmanagement.client;

import studentmanagement.service.*;
import studentmanagement.view.ViewPrinter;
import static studentmanagement.service.InputValidator.*;

public class Client {
    ViewPrinter view = new ViewPrinter();

    public void run() {
        view.printTitle();
        boolean cont = true;
        while(cont){
            Service service = selectUser();
            if (service != null) {
                service.loginMenu();
            }
            cont = !(service == null);
        }
        System.out.println();
    }

    private Service selectUser() {
        view.printUserSelection();
        int modeNum = getInput(0,2);
        switch (modeNum) {
            case 0 -> {
                view.printExit();
                return null;
            }
            case 1 -> {
                return new AdminService();
            }
            case 2 -> {
                return new StudentService();
            }
            default -> {
                view.printError();
                view.printExit();
                return null;
            }
        }
    }
}

