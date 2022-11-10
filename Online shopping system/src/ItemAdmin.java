package Project;

public class ItemAdmin extends  Item {

    ItemAdmin(String ItemName, String ItemGroup, int Itemid, float ItemPrice) {
        super(ItemName, ItemGroup, Itemid, ItemPrice);
    }

    static void ViewItem(int Itemid) { //كلاس لعرض عناصر محددة
        for (Item i : Item.ItemList) {
            if (i.getItemid() == Itemid) {
                System.out.println("\nid: " + i.getItemid() + "\nName: " + i.getItemName() + "\nGroup: "
                        + i.getItemGroup() + "\nPrice: " + i.getItemPrice());
                ItemAdmin.main(null);
            } else {
                System.out.println("Invalid id..No such Item");
            }
        }
    }


    static void AddItem() { //  كلاس اضافه عناصر
        System.out.println("Enter Item Name: "); //ادخل اسم العنصر
        String Name = in.next();
        System.out.println("Enter Item Group: "); // ادخل مجموعه العناصر
        String Group = in.next();
        System.out.println("Enter Item id: "); // ادخل معرف العنصر
        int id = in.nextInt();
        System.out.println("Enter Item Price: "); // ادخل سعر العنصر
        float Price = in.nextFloat();

        Item New = new Item(Name, Group, id, Price);
        ItemList.add(New);
        System.out.print("----Item added----"); // تمت اضافة العناصر
        ItemAdmin.main(null);
    }

    static void EditItem(int id) { //كلاس تعديل العناصر
        for (Item i : ItemList) {
            if (i.getItemid() == id) {
                Item old = i;
                System.out.println(toString(i));
                System.out.println("1.Change price\n" + //تغيير السعر
                                    "2.Back\n");

                int choicei = in.nextInt();
                switch (choicei) {
                    case 1:
                        System.out.println("Enter new price: "); //ادخل السعر الجديد
                        float ItemPrice = in.nextFloat();
                        Item Newe = new Item(i.getItemName(), i.getItemGroup(), i.getItemid(), ItemPrice);
                        ItemList.add(Newe);
                        ItemList.remove(old);
                        System.out.println("Price changed successfully");
                        break;
                    case 2:
                        ItemAdmin.main(null);
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
                ItemAdmin.main(null);
            } else {
                System.out.println("No such Item");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("\n1.View all Items\n" + // عرض كل العناصر
                             "2.View selected item\n" + // عرض عنصر محدد
                             "3.Edit Item\n" + // تحرير عنصر
                             "4.Add Item\n" + // اضافة عنصر
                             "5.Back"); // العودة
        int choosea2 = in.nextInt();
        switch (choosea2) {
            case 1:
                ViewAll();
                break;
            case 2:
                System.out.println("Enter id of item to be viewed");
                int itemid = in.nextInt();
                ItemAdmin.ViewItem(itemid);
                break;
            case 3:
                System.out.println("Enter id of item to be edited");
                int itemid2 = in.nextInt();
                ItemAdmin.EditItem(itemid2);
                break;
            case 4:
                ItemAdmin.AddItem();
                break;
            case 5:
                Administrator.main(args);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}


