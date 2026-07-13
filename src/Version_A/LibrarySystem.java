package Version_A;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Member> memberList = new ArrayList<>();

    private Book findBook(String isbn) {
        for (Book b : bookList) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }
    private Member findMember(String id) {
        for (Member m : memberList) {
            if (m.getMemberId().equals(id)) {
                return m;
            }
        }
        return null;
    }

}

public static void main(String[] args) {
    LibrarySystem library = new LibrarySystem();
    Scanner scanner = new Scanner(System.in);
    int choice;

    library.bookList.add(new Book("101", "Java Programming", "John Doe"));
    library.bookList.add(new Book("102", "Data Structures", "Jane Smith"));
    library.memberList.add(new Member("M01", "Alice"));

    System.out.println("== Welcome to the Library Management System ==");

    do {
        System.out.println("\n1. Add a Book");
        System.out.println("2. Register a Member");
        System.out.println("3. Borrow a Book");
        System.out.println("4. Return a Book");
        System.out.println("5. Display All Books");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");

        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 :
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();

                library.bookList.add(new Book(isbn, title, author));
                System.out.println("Book added successfully!");
                break;
            case 2 :
                System.out.print("Enter Member ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                library.memberList.add(new Member(id, name));
                System.out.println("Member registered successfully!");
                break;
            case 3 :
                System.out.print("Enter Member ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Book ISBN to borrow: ");
                String isbn = scanner.nextLine();

                Member member = library.findMember(id);
                Book book = library.findBook(isbn);


                if (member == null) {
                    System.out.println("Error: Member not found.");
                } else if (book == null) {
                    System.out.println("Error: Book not found.");
                } else if (!book.isAvailable()) {
                    System.out.println("Error: Book is already borrowed by someone else.");
                } else {
                    book.setAvailable(false);
                    member.borrowBook(book);
                    System.out.println("Success: " + member.getName() + " borrowed " + book.getTitle());
                }
                break;
            case 4 :
                System.out.print("Enter Member ID: ");
                id = scanner.nextLine();
                System.out.print("Enter Book ISBN to return: ");
                isbn = scanner.nextLine();

                member = library.findMember(id);
                book = library.findBook(isbn);

                if (member == null || book == null) {
                    System.out.println("Error: Invalid Member ID or ISBN.");
                } else if (member.getBorrowedBooks().contains(book)) {
                    book.setAvailable(true);
                    member.returnBook(book);
                    System.out.println("Success: Book returned successfully!");
                } else {
                    System.out.println("Error: This member didn't borrow this book.");
                }
                break;
            case 5 :
                System.out.println("\n--- Current Library Books ---");
                if (library.bookList.isEmpty()) {
                    System.out.println("No books in library.");
                } else {
                    for (Book b : library.bookList) {
                        b.displayInfo();
                    }
                }
                break;

        }
    } while (choice !=6 );

}
