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
    } while (choice !=6 );

}
