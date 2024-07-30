package studentmanagement.view;

public class AdminViewPrinter extends ViewPrinter {

    @Override
    public void printTitle(){
        System.out.println("--------------");
        System.out.println("  Admin Page  ");
        System.out.println("--------------");
    }

    @Override
    public void printMenu(){
        System.out.println("1.Student Management | 2.Teacher Management | 3.Edit Info | 0.Exit");
        System.out.print("Enter the number : ");
    }

    public void printManageMenu() {
        System.out.println("1.Create | 2.Read | 3.Update | 4.Delete | 0.Exit");
        System.out.print("Enter the number : ");
    }
}
