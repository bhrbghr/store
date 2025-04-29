package products;

public class Notebook extends Product {
    private int pageCount;
    private boolean isHardCover;
    private static int counter = 0;

    public Notebook(String title, Double price, int pageCount, boolean isHardCover) {
        super(title, price);
        this.pageCount = pageCount;
        this.isHardCover = isHardCover;
    }

    @Override
    protected String generateId() {
        counter++;
        return String.format("2%03d", counter);
    }

    @Override
    public String toString() {
        return super.toString() + ", Pages: " + pageCount + ", Hard Cover: " + isHardCover;
    }
}
