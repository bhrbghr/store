import inventory.*;
import products.*;

public class Main {
    public static double calculateTotalPrice(Inventory<? extends Product> inventory) {
        double total = 0;
        for (Product p : inventory.getItems()) {
            total += p.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Notebook> notebookInventory = new Inventory<>();
        Inventory<Accessory> accessoryInventory = new Inventory<>();

        bookInventory.addItems(new Book("Java Basics", 150.0, "Ali", "TechPub", "Programming"));
        bookInventory.addItems(new Book("Advanced Java", 200.0, "Sara", "CodeHouse", "Programming"));

        notebookInventory.addItems(new Notebook("Math Notebook", 50.0, 100, true));
        notebookInventory.addItems(new Notebook("Plain Notebook", 30.0, 80, false));

        accessoryInventory.addItems(new Accessory("Pen", 10.0, "Blue"));
        accessoryInventory.addItems(new Accessory("Eraser", 5.0, "White"));

        System.out.println("--- Display Products ---");
        bookInventory.displayAll();
        notebookInventory.displayAll();
        accessoryInventory.displayAll();

        System.out.println("\n--- Remove Item by ID ---");
        bookInventory.removeItemsById(1001);
        bookInventory.removeItemsById(1002);


        System.out.println("\n--- Apply Discount ---");
        accessoryInventory.applyDiscount("Pen", 20);
        accessoryInventory.applyDiscount("Eraser", 10);

        System.out.println("\n--- Total Prices ---");
        System.out.println("Total Book Price: " + calculateTotalPrice(bookInventory));
        System.out.println("Total Notebook Price: " + calculateTotalPrice(notebookInventory));
        System.out.println("Total Accessory Price: " + calculateTotalPrice(accessoryInventory));

        System.out.println("\n--- Find by ID ---");
        Product found = accessoryInventory.findItemsById(3001);
        if (found != null) System.out.println(found);

        System.out.println("\n--- Could not find by ID ---");
        Product Notfound = accessoryInventory.findItemsById(1001);

        System.out.println("\n--- Display Products ---");
        bookInventory.displayAll();
        notebookInventory.displayAll();
        accessoryInventory.displayAll();

    }
}
