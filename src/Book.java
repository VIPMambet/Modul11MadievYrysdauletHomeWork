import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable = true;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsLoaned() {
        isAvailable = false;
    }

    public void markAsAvailable() {
        isAvailable = true;
    }
}



class Librarian {
    private int id;
    private String name;
    private String position;

    public Librarian(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public void addBook(List<Book> library, Book book) {
        library.add(book);
        System.out.println("Библиотекарь " + name + " добавил(а) книгу: " + book.getTitle());
    }

    public void removeBook(List<Book> library, Book book) {
        if (library.contains(book)) {
            library.remove(book);
            System.out.println("Библиотекарь " + name + " удалил(а) книгу: " + book.getTitle());
        } else {
            System.out.println("Книга " + book.getTitle() + " не найдена в библиотеке.");
        }
    }
}

class Reader {
    private int id;
    private String name;
    private String email;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Reader(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.markAsLoaned();
            System.out.println(name + " взял(а) книгу: " + book.getTitle());
        } else {
            System.out.println("Книга " + book.getTitle() + " недоступна.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.markAsAvailable();
            System.out.println(name + " вернул(а) книгу: " + book.getTitle());
        } else {
            System.out.println(name + " не имеет книги: " + book.getTitle());
        }
    }
}




class Loan {
    private Book book;
    private Reader reader;
    private Date loanDate;
    private Date returnDate;

    public Loan(Book book, Reader reader) {
        this.book = book;
        this.reader = reader;
        this.loanDate = new Date();
    }

    public void issueLoan() {
        System.out.println("Книга \"" + book.getTitle() + "\" выдана читателю " + reader.getName() + " " +
                "дата выдачи: " + loanDate);
    }

    public void completeLoan() {
        this.returnDate = new Date();
        System.out.println("Читатель " + reader.getName() + " вернул(а) книгу \"" + book.getTitle() + "\" " +
                "дата возврата: " + returnDate);
    }
}
