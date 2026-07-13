package Version_B;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    //using AI
    private static final int MAX_BOOKS_ALLOWED = 3;
    private final String memberId;
    private final String name;
    private final List<Book> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

}
