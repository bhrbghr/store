package products;

public class Accessory extends Product {
    private String color;
    private static int counter = 0;

    public Accessory(String title, Double price, String color) {
        super(title, price);
        this.color = color;
    }

    @Override
    protected String generateId() {
        counter++;
        return String.format("3%03d", counter);
    }

    @Override
    public String toString() {
        return super.toString() + ", Color: " + color;
    }
}

