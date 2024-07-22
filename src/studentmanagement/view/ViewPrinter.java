package studentmanagement.view;


import studentmanagement.user.Student;

public class ViewPrinter {

    public void printAdminTitle(){
        System.out.println("----------------------------");
        System.out.println("  Admin Management Service  ");
        System.out.println("----------------------------");
    }

    public void printStudentTitle(){
        System.out.println("----------------------------");
        System.out.println(" Student Management Service ");
        System.out.println("----------------------------");
    }
    public void printModeSelection() {System.out.println("1.Admin | 2.Student | 3.Exit");}
    public void printLoginSelect() {System.out.println("1.Register | 2.Login | 3.Exit");}

    public void printSelection() {
        System.out.println("1.Create 2.Read 3.Search 4.Update 5.Delete 6.Exit");
        System.out.println("Enter the number");
    }
    public void printEnter(){
        System.out.print("Enter : ");
    }
    public void printInputId(){
        System.out.println("Enter your ID");
    }
    public void printInputPw(){
        System.out.println("Enter your Password");
    }
    public void printIsduplicatedId(){
        System.out.println("That ID already exists. Try again.");
    }

    public void printInputNumber() {
        System.out.println("Enter the number of Student");
    }

    public void printInputName() {
        System.out.println("Enter the name of Student");
    }

    public void printInputScore(String subject) {
        switch (subject) {
            case "Korean" -> System.out.println("Enter the Korean Score");
            case "Math" -> System.out.println("Enter the Math Score");
            case "English" -> System.out.println("Enter the English Score");
        }
    }
    public void printNoExist(){
        System.out.println("No Exist");
    }
    public void printSuccessFuction(String a){
        System.out.println(a+" Success!!");
    }

    public void printFuctionTitle(String title){
        System.out.println("[ "+title.toUpperCase()+" ]");
    }

    public void printError(){
        System.out.println("Error Occurred!!");
    }

    public void printInvalidInput(){
        System.out.println("[ERROR] Invalid Input, Try again");
    }

    public void printSelectionModify(){
        System.out.println("Choose the section you want to modify");
        System.out.println("1.Name 2.KoreanScore 3.MathScore 4.EnglishScore 0.Cancel");
    }
    public void printStudentInfo(Student student){
        System.out.println(student.getStudentInfo());
    }
    public void printIsDuplicatedStNum(){
        System.out.println("The student number already exists. Try again.");
    }
    public void printExit(){
        System.out.println("Exit..");
    }

}
