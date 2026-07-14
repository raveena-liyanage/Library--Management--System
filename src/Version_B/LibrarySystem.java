package Version_B;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
// AI Generated
public class LibrarySystem {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    private void addBook(String isbn, String title, String author) throws DuplicateEntryException {
        if (books.containsKey(isbn)) {
            throw new DuplicateEntryException("A book with ISBN " + isbn + " already exists.");
        }
        books.put(isbn, new Book(isbn, title, author));
    }

    private void registerMember(String id, String name) throws DuplicateEntryException {
        if (members.containsKey(id)) {
            throw new DuplicateEntryException("A member with ID " + id + " already exists.");
        }
        members.put(id, new Member(id, name));
    }
}
