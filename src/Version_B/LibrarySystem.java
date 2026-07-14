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
    private Book getBookOrThrow(String isbn) throws BookNotFoundException {
        Book book = books.get(isbn);
        if (book == null) {
            throw new BookNotFoundException("No book found with ISBN: " + isbn);
        }
        return book;
    }

    private Member getMemberOrThrow(String id) throws MemberNotFoundException {
        Member member = members.get(id);
        if (member == null) {
            throw new MemberNotFoundException("No member found with ID: " + id);
        }
        return member;
    }
    private Book getBookOrThrow(String isbn) throws BookNotFoundException {
        Book book = books.get(isbn);
        if (book == null) {
            throw new BookNotFoundException("No book found with ISBN: " + isbn);
        }
        return book;
    }

    private Member getMemberOrThrow(String id) throws MemberNotFoundException {
        Member member = members.get(id);
        if (member == null) {
            throw new MemberNotFoundException("No member found with ID: " + id);
        }
        return member;
    }
    private String promptNonEmpty(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        try {
            library.addBook("101", "Java Programming", "John Doe");
            library.addBook("102", "Data Structures", "Jane Smith");
            library.registerMember("M01", "Alice");
        } catch (DuplicateEntryException e) {
            System.out.println("Seed data error: " + e.getMessage());
        }

    }
}
