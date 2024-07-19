package studentmanagement.view;


import studentmanagement.student.Student;

public class ViewPrinter {

    public void printTitle(){
        System.out.println("--------------------");
        System.out.println(" Student Management ");
        System.out.println("--------------------");
    }
    public void printSelection() {
        System.out.println("1.Get 2.Read 3.Search 4.Update 5.Delete 6.Exit");
        System.out.println("Enter the number");
    }
    public void printEnter(){
        System.out.print("Enter : ");
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
    public void printisDuplicated(){
        System.out.println("The student number already exists. Try again.");
    }
    public void printExit(){
        System.out.println("Exit..");
    }

}
