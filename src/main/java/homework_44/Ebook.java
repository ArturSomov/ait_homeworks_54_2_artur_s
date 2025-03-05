package homework_44;

import lombok.Getter;

@Getter
class EBook extends Book {
    private final double fileSizeMb;

    public EBook(String title, String author, double fileSizeMb) {
        super(title, author);
        if (fileSizeMb <= 0) {
            throw new IllegalArgumentException("File size must be positive");
        }
        this.fileSizeMb = fileSizeMb;
    }

    @Override
    public String getDescription() {
        return String.format("E-Book: %s by %s (File size: %.2f MB)", title, author, fileSizeMb);
    }
}