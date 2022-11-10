package Project;

import java.util.*;

public class MainMenu {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
     {
        System.out.println("\n\t\t----ONLINE SHOPPING SYSTEM----\n");
        System.out.println("Choose whether you are an Admin or a Customer");
        System.out.println("1.Admin\n2.Customer \n3.Exit ");
        int choice = in.nextInt();


        switch(choice) {
            case 1:
                Administrator.main(null);   //استدعاء كلاس المدير
                break; 
            case 2:
                Customer.main(null);        //استدعاء كلاس عميل
                break;
            case 3:
                System.out.println("Exiting from program.."         //الخروج من البرنامج
                        + "\nThankyou for using this shopping system!");    //شكراً لك على استخدام نظام التسوق هذا
                System.exit(0);
            default:
                System.out.print("Worng Choice\n"); // اختيار غير صحيح
        }
    }
}

