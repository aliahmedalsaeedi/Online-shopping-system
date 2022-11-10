package Project;
import java.util.*;
public class Item {
    private String ItemName, ItemGroup;
    private int Itemid;
    private float ItemPrice;
    public static ArrayList<Item> ItemList = new ArrayList<Item>();
    static Scanner in = new Scanner(System.in);


    Item(String ItemName, String ItemGroup, int Itemid, float ItemPrice) {
        this.ItemName = ItemName;
        this.ItemGroup = ItemGroup;
        this.Itemid = Itemid;
        this.ItemPrice = ItemPrice;
    }

    static void ViewOnly(){
        for (Item i : ItemList) {
            System.out.println("\nid: " + i.getItemid() + "\nName: " + i.getItemName() +
                    "\nGroup: " + i.getItemGroup() + "\nPrice: " + i.ItemPrice);
        }
        Project.MainMenu.main(null);
    }

    static void ViewAll() {
        for (Item i : ItemList) {
            System.out.println("\nid: " + i.getItemid() + "\nName: " + i.getItemName()+
                    "\nGroup: " + i.getItemGroup() + "\nPrice: " + i.ItemPrice);
        }
        Item.main(null);
    }

    static void ViewAll(int  in) {  //كلاس لعرض جميع العناصر
        for (Item i : ItemList) {
            System.out.println("\nid: " + i.getItemid() + "\nName: " + i.getItemName() + "\nGroup: " + i.getItemGroup()
                    + "\nPrice: " + i.getItemPrice());
        }
        ItemAdmin.main(null); // بعد ذلك ينتقل الى مسؤؤل العناصر
    }

    static void ViewItem(int Itemid) { //كلاس لاستدعاء عرض عنصر فقط
        for (Item i : ItemList) {
            if (i.getItemid() == Itemid) {
                System.out.println("\nid: " + i.getItemid() + "\nName: " + i.getItemName() +
                        "\nGroup: " + i.getItemGroup() + "\nPrice: " + i.ItemPrice);
                System.out.println("Do you want to add this item to cart?"); // هل تريد اضافه هذا العنصر
                System.out.println("1.Yes\n2.No");
                int cartchoice = in.nextInt();
                switch (cartchoice) {
                    case 1:
                        ShoppingCart.AddToCart(i); // استدعاء كلاس عربة التسوق
                        break;
                    case 2:
                        Item.main(null); // استدعاء كلاس العنصر في الداله الرائسية
                        break;
                }
            }
        }
    }

    public static String toString(Item i) {
        return "\nid: " + i.getItemid() + "\nName: " + i.getItemName() + "\nGroup: " + i.getItemGroup() + "\nPrice: "
                + i.ItemPrice;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemGroup() {
        return ItemGroup;
    }

    public void setItemGroup(String itemGroup) {
        ItemGroup = itemGroup;
    }

    public int getItemid() {
        return Itemid;
    }

    public void setItemid(int itemid) {
        Itemid = itemid;
    }

    public float getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(float itemprice) {
        ItemPrice = itemprice;
    }


    public static void main(String[] args) {

        System.out.println( "1.View All Items\n" + // عرض كل العناصر
                            "2.View a selected Item"); //عرض عنصر محدد
        int choose = in.nextInt();
        switch (choose) {
            case 1:
                ViewAll(choose); // استدعاء كلاس عرض العناصر الكل
                break;
            case 2:
                System.out.println("Enter id of item to be viewed");
                int itemid = in.nextInt();
                ViewItem(itemid);//استدعاء عرض العنصر
                break;
            default:
                System.out.print("Invalid Choice\n");
        }
    }
}
