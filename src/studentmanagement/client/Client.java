package studentmanagement.client;

import studentmanagement.function.Function;
import studentmanagement.function.*;
import studentmanagement.function.Update;

import static studentmanagement.function.InputValidator.*;


public class Client {
    public void execute(){
        while(true){
            System.out.println("1.Get 2.Read 3.Search 4.Update 5.Delete 6.Exit");
            Function fuc = selectFunction();
            if(fuc == null){
                System.out.println("Exit...");
                break;
            }
            System.out.println();
            fuc.printFunction();
            fuc.run();

        }
    }

    private Function selectFunction(){
        System.out.println("Enter the number");
        int id = getInput(1,6);
        return switch(id){
            case 1 -> new Get();
            case 2 -> new Read();
            case 3 -> new Search();
            case 4 -> new Update();
            case 5 -> new Delete();
            case 6 -> null;
            default -> null;
        };
    }
}
