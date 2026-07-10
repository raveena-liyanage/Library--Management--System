package Version_A;
import java.util.ArrayList;

public class Member {
    private String memberId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getMemberId() {
        return memberId;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
    public void displayInfo() {
        System.out.println("Member ID: " + memberId + " | Name: " + name + " | Books Borrowed: " + borrowedBooks.size());
    }


}
