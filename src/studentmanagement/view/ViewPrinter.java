package studentmanagement.view;

public class ViewPrinter {

    void printSelection() {
        System.out.println("1.Get 2.Read 3.Search 4.Update 5.Delete 6.Exit");
        System.out.println("Enter the number");
    }
    void printEnter(){
        System.out.print("Enter : ");
    }

    void printInputNumber() {
        System.out.println("Enter the number of Student");
    }

    void printInputName() {
        System.out.println("Enter the name of Student");
    }
    void printWrongName(){
        System.out.println("Only Korean and English characters are allowed.");
    }

    void printInputScore(String subject) {
        switch (subject) {
            case "Korean" -> System.out.println("Enter the Korean Score");
            case "Math" -> System.out.println("Enter the Math Score");
            case "English" -> System.out.println("Enter the English Score");
        }
    }
    void printNoExist(){
        System.out.println("No Exist");
    }
    void printSuccessFuction(String a){
        System.out.println(a+" Success!!");
    }
}
