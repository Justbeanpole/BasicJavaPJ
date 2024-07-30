package studentmanagement.view;

public class StudentViewPrinter extends ViewPrinter {
    @Override
    public void printTitle() {
        System.out.println("----------------");
        System.out.println("  Student Page  ");
        System.out.println("----------------");
    }
    @Override
    public void printMenu(){
        System.out.println("1.My Info | 2.Edit Info | 0.Exit");
        System.out.print("Enter the number : ");
    }

    @Override
    public void printDuplicated() {
        System.out.println("The student number already exists. Try again.");
        System.out.println("Enter your student number : ");
    }

    @Override
    public void printSelectionModify() {
        System.out.println("Choose the section you want to modify");
        System.out.println("1.Name | 2.Password | 3.Korean Score | 4.Math Score | 5.English Score | 0.Exit");
        System.out.print("Enter the number : ");
    }
    public void superSelectionModify() {
        super.printSelectionModify();
    }

    public void printInputNumber() {
        System.out.print("Enter the number of Student : ");
    }

    public void printInputName() {
        System.out.print("Enter your name : ");
    }

    public void printInputScore(String subject) {
        switch (subject) {
            case "Korean" -> System.out.print("Enter the Korean Score : ");
            case "Math" -> System.out.print("Enter the Math Score : ");
            case "English" -> System.out.print("Enter the English Score : ");
        }
    }
}
