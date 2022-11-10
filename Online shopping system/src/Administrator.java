package Project;

import java.util.*;

public class Administrator {
    private String AdminName, adminemail;
    private int adminid, AdminPassword;
    static ArrayList<Administrator> AdministratorList = new ArrayList<Administrator>();
    static Scanner in = new Scanner(System.in);

    Administrator(String AdminName, String adminemailid, int AdminPassword, int adminid) {
        this.AdminName = AdminName;
        this.adminemail = adminemailid;
        this.AdminPassword = AdminPassword;
        this.adminid = adminid;
    }

    static void Register()  {       //كلاس تسجيل المسؤول
        System.out.println("Enter Name: ");     // ادخال الاسم
        String AdminName = in.next();
        System.out.println("Enter email: ");    //ادخال الايميل
        String adminemailid = in.next();
        System.out.println("Enter password (numbers only): ");      //ادخال كلمة المرور ارقام فقط
        int AdminPassword = in.nextInt();
        System.out.println("Enter admin id (numbers only): ");      //ادخال رقم المسؤول اراقم فقط
        int adminid = in.nextInt();

        Administrator New = new Administrator(AdminName, adminemailid, AdminPassword, adminid);
        AdministratorList.add(New);

        System.out.print("Admin Successfully Registered..");  // تم تسجيل المسؤول بنجاح
        Administrator.afterloginadmin(New);
    }


    static void afterloginadmin(Administrator i) {
        System.out.println("\nWelcome " + i.AdminName + "\n\nChoose option...");
        System.out.println( "1.Manage Account(Admin)\n" + // اداره الحساب
                "2.Item Menu\n" + // قائمة العناصر
                "3.Back"); // العودة

        int choosea = in.nextInt();
        switch (choosea) {
            case 1:
                Manage_Account(i.adminid);
                break;
            case 2:
                ItemAdmin.main(null);
                break;
            case 3:
                Administrator.main(null);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }


    static void Manage_Account(int id) {
        for (Administrator i : AdministratorList) {
            if (i.adminid == id) {
                Administrator old = i;
                System.out.println(toString(i));
                System.out.println("\nMANAGE ACCOUNT\n" + // اداره الحساب
                                    "1.Change password\n" + //تغيير كلمة السر
                                    "2.Change emailid\n" + // تغيير الايميل
                                    "3.Back");// العودة

                int choicea = in.nextInt();
                switch (choicea) {
                    case 1:
                        System.out.println("Enter old password: "); // ادخال رمز القديم
                        int oldp = in.nextInt();
                        if (i.AdminPassword == oldp) {
                            System.out.println("Enter new password: "); // ادخال رمز الجديد
                            int AdminPassword = in.nextInt();
                            Administrator Newp = new Administrator(i.AdminName, i.adminemail, AdminPassword, i.adminid);
                            AdministratorList.add(Newp);
                            System.out.println("Password changed successfully"); // تم التغيير بنجاح
                        }
                        break;
                    case 2:
                        System.out.println("Enter old email: ");
                        String olde =in.next();
                        if (i.adminemail.equals(olde)) {
                            System.out.println("Enter new email: ");
                            String adminemailid = in.next();
                            Administrator Newe = new Administrator(i.AdminName, adminemailid, i.AdminPassword, i.adminid);
                            AdministratorList.add(Newe);
                            System.out.println("email changed successfully"); // تم تغيير الايميل بنجاح
                        }
                        break;
                    case 3:
                        Administrator.afterloginadmin(i);
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
                AdministratorList.remove(old);
                Administrator.afterloginadmin(i); // بعد التغيير يرجع لنا الئ كلاس بعد التسجيل
            }
        }
    }




    static void Login()  {
        System.out.println("Enter Admin id: ");
        int adminid = in.nextInt();
        System.out.println("Enter password: ");
        int AdminPassword = in.nextInt();

        for (Administrator i : AdministratorList) {
            if (i.adminid == adminid && i.AdminPassword == AdminPassword) {
                Administrator.afterloginadmin(i);
            } else {
                System.out.println("Admin id and password does not match/exist");
                Administrator.main(null);
            }
        }
    }



    public static String toString(Administrator i) {
        return "\nName: "  + i.AdminName + "\nPassword: " + i.AdminPassword + "\nemailid: " + i.adminemail + "\nid: " + i.adminid;
    }


    public static void main(String[] args)  {


        System.out.println("1.Register \n" + // تسجيل
                           "2.Admin Login \n" + // تسجيل المسؤول
                           "3.Back "); //العودة
        int choosemaina = in.nextInt();
        switch (choosemaina) {
            case 1:
                Administrator.Register();
                break;
            case 2:
                Administrator.Login();
                break;
            case 3:
                MainMenu.main(null);
                break;
            default:
                System.out.print("Invalid Choice\n");
        }
    }
}

