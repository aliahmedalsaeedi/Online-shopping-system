package Project;

import java.util.*;

public class CheckOut {

    private static String Address, Housenum, State;
    private static double Pincode;
    private static int Phoneno;

    static Scanner in = new Scanner(System.in);

    static void Details() // بناء التفاصيل
    {
        System.out.println("The delivery details for your order: "); // تفاصيل التسليم الطلب
        System.out.println("Enter Delivery Address: "); // ادخل عنوان التسليم
        Address = in.next();
        System.out.println("Enter House number: "); // ادخل عنوان المنزل اي الرقم
        Housenum = in.next();
        System.out.println("Enter State:"); //ادخل اسم الدولة
        State = in.next();
        System.out.println("Enter Phoneno: ");// ادخل رقم الهاتف
        Phoneno = in.nextInt();
        System.out.println("Enter Pincode: "); //ادخل الرمز السري اي الكود
        Pincode = in.nextDouble();

    }

    public static void main(String[] args) {

        System.out.println("--Mode of Payment--" + // طريقة الدفع
                "\n" + "Choose the option:" + "\n" +
                "1. ATM cards." + "\n" + // عبر بطاقة الصراف الالي _ مدين
                "2. Cash on Delivery." + "\n" + //الدفع عند الاستلام
                "3.Back."); //الرجوع

        int Choice = in.nextInt();
        switch (Choice) {
            // Cards
            case 1:
                CheckOut.Details(); // عرض التفاصيل
                System.out.print("Enter the name of the card holder:"); // ادخل اسم حامل البطاقة
                String CardName = in.next();
                System.out.print("Enter the card number:"); //ادخل رقم البطاقة
                long CardNo = in.nextLong();
                System.out.print("Enter the expiry DD/MM/YYYY");    // ادخل تاريخ أنتهاء صلاحية
                int ExpDate = in.nextInt();
                System.out.println("Verify you delivery details \n"); // تحقق من بطاقة التسليم
                System.out.println(Address + "\n" + Housenum + "\n" + State + "\n" + Phoneno + "\n" + Pincode);

                System.out.println("1. To continue payment" + "\n"  // لمواصلة الدفع
                        + "2. To stop payment" + "\n");     //لوقف الدفع
                int cardchoice = in.nextInt();
                if (cardchoice == 1) {
                    System.out.println("-----------Your order is success----------"); // تم الطلب بنجاح
                    System.out.println("Exiting from program..\n" + // الخروج من البرنامج
                            "Thankyou for using this shopping system!"); // شكرا على استخدام نظام التسوق
                    System.exit(0);
                } else {
                    System.out.println("-----------Your order is cancelled-----------"); // تم الغاء الطلب
                    ShoppingCart.PrintInvoice();
                }
                break;

            case 2:
                CheckOut.Details();
                System.out.println("Verify you delivery details"); // التحقق من التفاصيل
                System.out.println(Address + "\n" + Housenum + "\n" + State + "\n" + "\n" + Phoneno + "\n" + Pincode);
                System.out.println("\n" + "1. To continue" // تواصل
                        + "\n" + "2. To stop " + "\n"); //ايقاف
                int codchoice = in.nextInt();
                if (codchoice == 1) {
                    System.out.println("-----------Your order is success----------");
                    System.out.println("Exiting from program..\nThankyou for using this shopping system!");
                    System.exit(0);

                } else {
                    System.out.println("-----------Your order is cancelled-----------");
                    ShoppingCart.PrintInvoice();
                }
                break;

            case 3:
                ShoppingCart.PrintInvoice();
                break;
        }
    }
}
