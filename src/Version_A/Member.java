package Version_A;
import java.util.ArrayList;

public class Member {
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


}
