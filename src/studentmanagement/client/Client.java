package studentmanagement.client;

import com.sun.jdi.event.ExceptionEvent;
import studentmanagement.function.*;
import studentmanagement.student.Student;

import static studentmanagement.function.InputValidator.*;


public class Client {
    public void execute(){
        while(true){

            selectFunction();
            System.out.println();
        }
    }

    private void selectFunction(){
        ManageSystem ms = ManageSystem.getInstance();
        int id = getInput(1,6);
        switch(id){
            case 1 -> ms.getFuc();
            case 2 -> ms.readFuc();
            case 3 -> ms.searchFuc();
//            case 4 -> ms.updateFuc();
            case 5 -> ms.deleteFuc();
            case 6 -> System.exit(0); //종료 함수 대체
            default -> System.exit(0); //에러 발생 메세지 및 종료
        };
    }
}
