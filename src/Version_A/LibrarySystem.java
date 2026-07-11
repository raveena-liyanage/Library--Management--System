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
    for (Member m : memberList) {
        if (m.getMemberId().equals(id)) {
            return m;
        }
    }

}
