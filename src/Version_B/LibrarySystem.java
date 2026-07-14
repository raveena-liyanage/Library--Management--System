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
    private void borrowBook(String memberId, String isbn)
            throws MemberNotFoundException, BookNotFoundException, BookNotAvailableException {
        Member member = getMemberOrThrow(memberId);
        Book book = getBookOrThrow(isbn);

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("\"" + book.getTitle() + "\" is already borrowed.");
        }
        if (member.hasReachedBorrowLimit()) {
            throw new BookNotAvailableException(member.getName() + " has reached the maximum borrow limit.");
        }

        book.setAvailable(false);
        member.borrowBook(book);
        System.out.println("Success: " + member.getName() + " borrowed \"" + book.getTitle() + "\".");
    }

    private void returnBook(String memberId, String isbn)
            throws MemberNotFoundException, BookNotFoundException, BookNotBorrowedException {
        Member member = getMemberOrThrow(memberId);
        Book book = getBookOrThrow(isbn);

        if (!member.getBorrowedBooks().contains(book)) {
            throw new BookNotBorrowedException(member.getName() + " did not borrow \"" + book.getTitle() + "\".");
        }

        book.setAvailable(true);
        member.returnBook(book);
        System.out.println("Success: \"" + book.getTitle() + "\" has been returned.");
    }

    private void displayAllBooks() {
        System.out.println("\n--- Current Library Books ---");
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    private void displayAllMembers() {
        System.out.println("\n--- Registered Members ---");
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        members.values().forEach(System.out::println);
    }

    private void searchBookByTitle(String keyword) {
        System.out.println("\n--- Search Results ---");
        String lowerKeyword = keyword.toLowerCase();
        boolean found = false;
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(lowerKeyword)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books matched \"" + keyword + "\".");
        }
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
        System.out.println("== Welcome to the Library Management System ==");

        while (choice != 8) {
            System.out.println("\n1. Add a Book");
            System.out.println("2. Register a Member");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display All Members");
            System.out.println("7. Search Book by Title");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine();
                continue;
            }
            try {
                switch (choice) {
                    case 1:
                        String isbn = library.promptNonEmpty(scanner, "Enter ISBN: ");
                        String title = library.promptNonEmpty(scanner, "Enter Title: ");
                        String author = library.promptNonEmpty(scanner, "Enter Author: ");
                        library.addBook(isbn, title, author);
                        System.out.println("Book added successfully!");
                        break;
                    case 2:
                        String id = library.promptNonEmpty(scanner, "Enter Member ID: ");
                        String name = library.promptNonEmpty(scanner, "Enter Name: ");
                        library.registerMember(id, name);
                        System.out.println("Member registered successfully!");
                        break;
                    case 3:
                        String borrowId = library.promptNonEmpty(scanner, "Enter Member ID: ");
                        String borrowIsbn = library.promptNonEmpty(scanner, "Enter Book ISBN to borrow: ");
                        library.borrowBook(borrowId, borrowIsbn);
                        break;
                    case 4:
                        String returnId = library.promptNonEmpty(scanner, "Enter Member ID: ");
                        String returnIsbn = library.promptNonEmpty(scanner, "Enter Book ISBN to return: ");
                        library.returnBook(returnId, returnIsbn);
                        break;
                    case 5:
                        library.displayAllBooks();
                        break;
                    case 6:
                        library.displayAllMembers();
                        break;
                    case 7:
                        String keyword = library.promptNonEmpty(scanner, "Enter title keyword: ");
                        library.searchBookByTitle(keyword);
                        break;
                    case 8:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.");
                        break;
                }
            } catch (DuplicateEntryException | BookNotFoundException | MemberNotFoundException
                     | BookNotAvailableException | BookNotBorrowedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
