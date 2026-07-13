package Version_B;

//Using AI
class DuplicateEntryException extends Exception {
    public DuplicateEntryException(String message) {
        super(message);
    }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class MemberNotFoundException extends Exception {
    public MemberNotFoundException(String message) {
        super(message);
    }
}

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class BookNotBorrowedException extends Exception {
    public BookNotBorrowedException(String message) {
        super(message);
    }
}