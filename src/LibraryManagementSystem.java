import java.util.List;
import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Создание объектов
        Librarian librarian = new Librarian(1, "Алиса", "Главный библиотекарь");
        Reader reader = new Reader(1, "Иван Иванов", "ivan.ivanov@example.com");

        List<Book> library = new ArrayList<>();

        // Добавление книг
        Book book1 = new Book("Программирование на Java", "Автор A", "123-456");
        Book book2 = new Book("Структуры данных", "Автор B", "789-101");

        librarian.addBook(library, book1);
        librarian.addBook(library, book2);

        // Выдача книги
        reader.borrowBook(book1);
        Loan loan = new Loan(book1, reader);
        loan.issueLoan();

        // Возврат книги
        reader.returnBook(book1);
        loan.completeLoan();

        // Удаление книги
        librarian.removeBook(library, book1);
    }
}
