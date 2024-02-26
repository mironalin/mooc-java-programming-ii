public class Book implements Packable {
    private String bookAuthor;
    private String bookName;
    private double weight;

    public Book(String author, String name, double weight) {
        this.bookAuthor = author;
        this.bookName = name;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    public String toString() {
        return this.bookAuthor + ": " + this.bookName;
    }
}
