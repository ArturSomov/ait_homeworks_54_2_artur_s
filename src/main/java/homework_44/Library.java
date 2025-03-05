package homework_44;

import java.util.ArrayList;
import java.util.List;

class Library<T extends Book> {
    private final List<T> books = new ArrayList<>();

    public void addBook(T book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
    }

    public boolean removeBook(String title) {
        if (title == null) {
            return false;
        }
        return books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public T findBook(String title) {
        if (title == null) {
            return null;
        }
        for (T book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            int index = 1;
            for (T book : books) {
                System.out.println(index++ + ". " + book.getDescription());
            }
        }
    }

    public List<T> getBooks() {
        return List.copyOf(books);
    }
}
