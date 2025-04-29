package products;

public class Book extends Product {
    private String author;
    private String publication;
    private String genre;
    private static int counter = 0;

    public Book(String title, Double price, String author, String publication, String genre) {
        super(title, price);
        this.author = author;
        this.publication = publication;
        this.genre = genre;
    }

    @Override
    protected String generateId() {
        counter++;
        return String.format("1%03d", counter);
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author + ", Publication: " + publication + ", Genre: " + genre;
    }
}

