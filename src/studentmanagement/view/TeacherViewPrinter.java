package studentmanagement.view;

public class TeacherViewPrinter extends ViewPrinter {
    @Override
    public void printTitle(){
        System.out.println("----------------");
        System.out.println("  Teacher Page  ");
        System.out.println("----------------");
    }

    @Override
    public void printLoginSelect() {
        System.out.println("1.Register | 2.Login | 0.Exit");
        System.out.print("Enter the number : ");
    }
    @Override
    public void printMenu(){
        System.out.println("1.My Info | 2.Edit Info | 3.Student Management | 0.Exit");
        System.out.print("Enter the number : ");
    }
    @Override
    public void printSelectionModify(){
        System.out.println("Choose the section you want to modify");
        System.out.println("1.Name | 2.Password | 3.Subject | 0.Exit");
        System.out.print("Enter the number : ");
    }
    public void printInputSubject(){System.out.print("Enter your Subject : ");}
    public void printEditTeacher(){
        System.out.println("Choose the section you want to modify");
        System.out.println("1.Name | 2.Password | 3.Subject | 0.Exit");
        System.out.print("Enter the number : ");
    }
}

