package homework_44;

import lombok.Getter;

@Getter
class PaperBook extends Book {
    private final int pages;

    public PaperBook(String title, String author, int pages) {
        super(title, author);
        if (pages <= 0) {
            throw new IllegalArgumentException("Number of pages must be positive");
        }
        this.pages = pages;
    }

    @Override
    public String getDescription() {
        return String.format("Paper Book: %s by %s (%d pages)", title, author, pages);
    }
}