package studentmanagement.view;


public class ViewPrinter {

    public void printTitle(){
        System.out.println("----------------------------");
        System.out.println(" Student Management System ");
        System.out.println("----------------------------");
    }

    public void printUserSelection() {
        System.out.println("1.Admin | 2.Student | 3.Teacher | 0.Exit");
        System.out.print("Enter the number : ");}

    public void printLoginSelect() {
        System.out.println("1.Login | 0.Exit");
        System.out.print("Enter the number : ");}

    public void printMenu(){
        System.out.println("1.Service | 2.Service | 0.Exit");
        System.out.print("Enter the number : ");
    }

    public void printInputId(){
        System.out.print("Enter your ID : ");
    }
    public void printInputPw(){
        System.out.print("Enter your Password : ");
    }
    public void printInputName() {System.out.print("Enter your Name : ");}


    public void printFailLogin(){
        System.out.println("Login Failed, Try Again");
    }

    public void printDuplicated(){
        System.out.println("That ID already exists. Try again.");
        System.out.println("Enter your ID : ");
    }

    public void printFunctionTitle(String title){
        System.out.println("[ "+title.toUpperCase()+" ]");
    }

    public void printSelectionModify(){
        System.out.println("Choose the section you want to modify");
        System.out.println("1.Name | 2.Password | 0.Exit");
        System.out.print("Enter the number : ");
    }

    public void printInvalidInput(){
        System.out.println("[ERROR] Invalid Input, Try again");
        System.out.print("Enter : ");
    }

    public void printSuccess(String a){
        System.out.println(a+" Success!!");
    }
    public void printNoExist(){
        System.out.println("Nothing Found");
    }
    public void printExit(){
        System.out.println("Exit..");
    }
    public void printError(){
        System.out.println("Error Occurred!!");
    }

}
