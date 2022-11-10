
package Project;
import java.util.*;

public class ShoppingCart { // كلاس بناء التسوق

    static ArrayList<Item> cartItems = new ArrayList<Item>();
    static float total = 0;
    static Scanner in = new Scanner(System.in);

    public static void AddToCart(Item i) // كلاس لاضافه العناصر
    {
        System.out.println("Item added successfully ..");      //تمت الاضافة بنجاح
        cartItems.add(i);
        System.out.println("Do you want to continue or checkout? "); // هل تريد الاستمرار او الخروج
        System.out.println("1.Continue Shopping\n" + //مواصلةالتسوق
                            "2.Checkout"); // الدفع
        int schoice = in.nextInt();
        switch (schoice)
        {
            case 1:
                Item.main(null);        // استدعاء كلاس العنصر
                break;
            case 2:
                ShoppingCart.PrintInvoice(); // استدعاء كلاس عربه التسوق
                break;
        }
    }

    public static void RemoveItem(int id) //بناء حذف بند
    {
        for (Item i : cartItems)
        {
            if (i.getItemid() == id)
            {
                cartItems.remove(i);
                float price = i.getItemPrice();
                total -= price;
            } else {
                System.out.println("No such item in cart"); //لايوجد بند في في عربه التسوق
                ShoppingCart.PrintInvoice();
            }
        }
        ShoppingCart.PrintInvoice();
    }

    public static float TotalPrice()
    {
        total = 0;
        for (Item i : cartItems)
        {
            float price = i.getItemPrice();
            total += price;
        }
        return total;
    }

    public static void PrintInvoice() // بناء السعر الكلي
    {
        for (Item i : cartItems) {
            System.out.println(i.getItemid());
            System.out.println(i.getItemName());
            System.out.println(i.getItemPrice());
        }
        System.out.println("Total Amount = " + TotalPrice());
        System.out.println("Do you want to continue to payment or remove items in cart?");
        // هل تريد الاستمرار في الدفع او ازالة العناصر
        System.out.println("1.Make Payment\n" + // قم بالدفع
                 "2.Edit Cart"); // تحرير عربة النسوق

        int schoice2 = in.nextInt();
        switch (schoice2) {
            case 1:
                CheckOut.main(null);        // استدعاء كلاس الدفع
                break;
            case 2:
                System.out.println("Enter id of the item to be removed"); // ادخال رقم العنصر الذي تريد ازالته
                int idremove = in.nextInt();
                ShoppingCart.RemoveItem(idremove);
                break;
        }
    }
}
