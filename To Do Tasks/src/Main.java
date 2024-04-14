import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static ArrayList<Item> itemList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    public static void main(String...args){
        char choice;

        do{
            System.out.println("Welcome Manager");
            System.out.println("1. View Items");
            System.out.println("2. Add Items");
            System.out.println("3. Delete Items");
            System.out.println("4. Search Items");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1 -> viewItem();
                case 2 -> addItem();
                case 3 -> deleteItem();
                case 4 -> searchItem();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice");
                    return;
                }
            }
            System.out.println("Do you wish to continue?(Y/N)");
            choice = scan.nextLine().charAt(0);

        }while( Character.toUpperCase(choice)=='Y');
            System.out.println("Program terminated");

    }
    public static void addItem() {


        System.out.println("Enter item name");
        boolean em = false;
        String name;
        do{
            name = scan.nextLine();
            if (name.isBlank()){
                System.out.println("Cant be blank. Try again");
                System.out.println("Enter item name");
            }
            else{
                em = true;
            }

        }while(!em);




        System.out.println("Enter item price");
        Double price = scan.nextDouble();

        System.out.println("Enter item description");
        String description = scan.nextLine();

        Item newItem = new Item(name, price, description);
        itemList.add(newItem);
        System.out.println("Item added successfully");
    }
    public static void deleteItem(){
        if(itemList.isEmpty()){
            System.out.println("No items to delete");
            return;
        }
        System.out.println("Enter item to delete");
        String name = scan.nextLine();

        boolean found = false;
        for (Item item : itemList){
            if (item.name.equalsIgnoreCase(name)){
                itemList.remove(item);
                System.out.println("Item deleted successfully");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Item not found");

        }

    }
    public static void searchItem(){

        if (itemList.isEmpty()){
            System.out.println("No items to search");
            return;
        }

        System.out.println("Enter item name");
        String name = scan.nextLine();

        boolean found = false;
        for (Item item : itemList){
            if (item.name.equalsIgnoreCase(name)){
                System.out.println("Name: "+item.name);
                System.out.println("Price: "+item.price);
                System.out.println("Description: "+item.description);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found");

        }
    }
    public static void viewItem(){
        if (itemList.isEmpty()){
            System.out.println("No items to view");
            return;
        }

        System.out.println("List of items:");
        for (Item item: itemList){
            System.out.println("Name: "+item.name);
            System.out.println("Price: "+item.price);
            System.out.println("Description: "+item.description);

        }
    }
}
class Item{
    String name;
    Double price;
    String description;

    public Item (String name, Double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }
}