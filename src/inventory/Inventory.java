package inventory;
import products.*;
import java.util.ArrayList;

public class Inventory<T extends Product> {
    private ArrayList<T> items = new ArrayList<>();

    public void addItems(T product) {
        items.add(product);
    }

    public void removeItemsById(int id) {
        Product toRemove = null;
        for (T item : items) {
            try {
                if (Integer.parseInt(item.getId()) == id) {
                    toRemove = item;
                    break;
                }
            } catch (NumberFormatException e) {
            }
        }

        if (toRemove != null) {
            items.remove(toRemove);
            System.out.println("Removed item: " + toRemove);
        } else {
            System.out.println("Item with ID " + id + " not found.");
        }
    }


    public T findItemsById(int id) {
        for (T item : items) {
            if (Integer.parseInt(item.getId()) == id)
                return item;
        }
        System.out.println("Item with ID " + id + " not found.");
        return null;
    }

    public void applyDiscount(String productName, int discount) {
        boolean found = false;
        for (T item : items) {
            if (item.getTitle().equalsIgnoreCase(productName)) {
                found = true;
                double oldPrice = item.getPrice();
                double newPrice = oldPrice - (oldPrice * discount / 100.0);
                item.setPrice(newPrice);
                System.out.printf("Discount applied to %s:\nOld Price: %.2f, New Price: %.2f\n",
                        item.getTitle(), oldPrice, newPrice);
            }
        }
        if (!found) {
            System.out.println("Product not found for discount: " + productName);
        }
    }


    public void displayAll() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    public ArrayList<T> getItems() {
        return items;
    }
}
