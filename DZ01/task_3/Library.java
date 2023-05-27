package DZ01.task_3;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> catalog = new ArrayList<>();

    private boolean contains(Book b) {
        for (Book book : catalog) {
            if (book.getTitle().equals(b.getTitle()) && book.getAuthor().equals(b.getAuthor())) return true;
        }
        return false;
    }

    private void updateBookAvalaible(Book b, boolean a) {
        for (Book book : catalog) {
            if (book.getTitle().equals(b.getTitle()) && book.getAuthor().equals(b.getAuthor())) {
                book.setAvailable(a);
                return;
            }
        }
    }

    public void addBook(Book b) {
        if (this.contains(b)) {
            updateBookAvalaible(b, true);
        } else {
            catalog.add(b);
        }
    }

    public void removeBook(Book b) {
        if (this.contains(b)) {
            updateBookAvalaible(b, false);
        }
    }

    public void displayAvailableBooks() {
        System.out.printf("-------\nВсе доступные книги:\n");
        for (Book book : catalog) {
            if (book.isAvailable()) book.displayInfo();
        }
    }

    public void displayAvailableBooks(String author) {
        System.out.printf("-------\nДоступные книги автора %s:\n", author);
        for (Book book : catalog) {
            if (book.isAvailable() && book.getAuthor().equals(author)) book.displayInfo();
        }
    }

    public void searchByAuthor(String author) {
        System.out.printf("-------\nВсе книги автора %s:\n", author);
        for (Book book : catalog) {
            if (book.getAuthor().equals(author)) book.displayInfo();
        }
    }
}
