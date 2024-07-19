package studentmanagement.client;

import studentmanagement.function.*;
import studentmanagement.view.ViewPrinter;

import static studentmanagement.function.InputValidator.*;


public class Client {
    ViewPrinter view = new ViewPrinter();
    ManagementService ms = ManagementService.getInstance();
    public void execute(){
        view.printTitle();
        while(true){
            selectFunction();
            System.out.println();
        }
    }

    private void selectFunction(){
        view.printSelection();
        int id = getInput(1,6);
        switch(id){
            case 1 -> ms.input();
            case 2 -> ms.read();
            case 3 -> ms.search();
            case 4 -> ms.update();
            case 5 -> ms.delete();
            case 6 -> ms.exitSystem();
            default -> ms.errorSystem();
        };
    }
}
