package Project;
import java.util.*;

public class Customer{
    private String Name;
    private String Address;
    private String emailid;
    private int Phone;
    private int id, Password;

    static ArrayList<Customer> CustomerList = new ArrayList<Customer>();
    static Scanner in = new Scanner(System.in);

    Customer(String Name, String Address, String emailid, int Phoneno, int id, int Password) {
        this.Name = Name;
        this.Address = Address;
        this.emailid = emailid;
        this.Phone = Phoneno;
        this.id = id;
        this.Password = Password;
    }

        static void Register() {    // كلاس التسجيل
        System.out.println("Enter Name: "); // ادخل الاسم
        String Name = in.next();
        System.out.println("Enter Address: "); // ادخل العنوان
        String Address = in.next();
        System.out.println("Enter email: "); //ادخل الايميل
        String emailid = in.next();
        System.out.println("Enter Phone: "); //ادخل الرقم
        int Phone = in.nextInt();
        System.out.println("Enter id (numbers only): "); // ادخل المعرف الخاص
        int id = in.nextInt();
        System.out.println("Enter password (numbers only): "); //الدخل الباسورد
        int Password = in.nextInt();

        Customer New = new Customer(Name, Address, emailid, Phone, id, Password);
        CustomerList.add(New);

        System.out.print("User Successfully Registered\n"); //تم تسجيل المستخدم بنجاح
        afterlogin(New);
    }


    static void afterlogin(Customer i) {    // بعد تسجيل الدخول
        System.out.println("\nWelcome " + i.Name + "\nChoose option");
        System.out.print("1.Item Menu\n" + //قائمة العناصر
                         "2.Manage Account\n" + //إداره الحاسب
                         "3.Back\n"); //العودة
        int choose2c = in.nextInt();

        switch (choose2c) {
            case 1:
                Item.main(null);    //استدعاء العنصر الرائسي
                break;
            case 2:
                Customer.Manage_Account(i.id);
                break;
            case 3:
                Customer.main(null);
                break;
            default:
                System.out.print("Invalid Choice\n");
        }
    }


    static void Login(){ // تسجيل الدخول
        System.out.println("Enter UserName id: ");
        int id = in.nextInt();
        System.out.println("Enter password: ");
        int Password = in.nextInt();

        for (Customer i : CustomerList) {
            if (i.id == id && i.Password == Password) {
                Customer.afterlogin(i);
            } else {
                System.out.println("User id and password does not match/exist");
                Customer.main(null);
            }
        }
    }



    static void Manage_Account(int id){ // اداره العداد
        for (Customer i : CustomerList) {
            if (i.id == id) {
                Customer old = i;
                System.out.println(toString(i));
                System.out.println("MANAGE ACCOUNT\n1.Change Password\n2.Change Address\n3.Change Phoneno"
                        + "\n4.Change emailid\n5.Back\n");

                int choosec = in.nextInt();
                switch (choosec) {
                    case 1:
                        System.out.println("Enter old password: ");
                        int oldp = in.nextInt();
                        if (i.Password == oldp) {
                            System.out.println("Enter new password: ");
                            int Password = in.nextInt();
                            Customer Newp = new Customer(i.Name, i.Address, i.emailid, i.Phone, i.id, Password);
                            CustomerList.add(Newp);
                            System.out.println("Password changed successfully");
                        }
                        break;
                    case 2:
                        System.out.println("Enter new Address: ");
                        String Address = in.next();
                        Customer Newa = new Customer(i.Name, Address, i.emailid, i.Phone, i.id, i.Password);
                        CustomerList.add(Newa);
                        System.out.println("Address changed successfully");
                        break;
                    case 3:
                        System.out.println("Enter new Phone number: ");
                        int Phoneno = in.nextInt();
                        Customer Newpn = new Customer(i.Name, i.Address, i.emailid, Phoneno, i.id, i.Password);
                        CustomerList.add(Newpn);
                        System.out.println("Phone No changed successfully");
                        break;
                    case 4:
                        System.out.println("Enter emaild: ");
                        String emailid = in.next();
                        Customer Newe = new Customer(i.Name, i.Address, emailid, i.Phone, i.id, i.Password);
                        System.out.println("emailid changed successfully");
                        CustomerList.add(Newe);
                        break;
                    case 5:
                        Customer.afterlogin(i);
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
                CustomerList.remove(old);
                Customer.afterlogin(i);
            }
        }
    }


    public static String toString(Customer i) {
        return "\nName: " + i.Name + "\nAddress: " + i.Address + "\nemailid: " + i.emailid + "\nPhoneno: " + i.Phone
                + "\nid: " + i.id;
    }



    public static void main(String[] args) {


        System.out.println( "1.Register \n" + // تسجيل
                            "2.Login \n" + //تسجيل الدخول
                            "3.View Items\n" + // عرض العناصر
                            "4.Back\n"); // العودة
        int choosemainc = in.nextInt();
        switch (choosemainc) {
            case 1:
                Customer.Register();
                break;
            case 2:
                Customer.Login();
                break;
            case 3:
                Item.ViewOnly();
            case 4:
                MainMenu.main(args);
                break;
            default:
                System.out.print("Invalid Choice\n");
        }
    }
}
