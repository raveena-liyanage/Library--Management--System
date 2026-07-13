package Version_B;

//written manually
public class Book {
    private final String isbn;
    private final String title;
    private final String author;

    // using AI
    private boolean available;
    //written manually
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }
}
