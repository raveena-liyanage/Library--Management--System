package Version_A;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }

}
