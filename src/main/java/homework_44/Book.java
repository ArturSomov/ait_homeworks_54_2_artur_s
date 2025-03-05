package homework_44;

import lombok.Getter;

@Getter
abstract class Book {
    protected final String title;
    protected final String author;

    public Book(String title, String author) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.title = title;
        this.author = author;
    }

    public abstract String getDescription();
}
