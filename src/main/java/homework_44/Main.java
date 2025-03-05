package homework_44;

public class Main {

    public static void main(String[] args) {

        Library<PaperBook> paperLibrary = new Library<>();
        paperLibrary.addBook(new PaperBook("War and Peace", "Leo Tolstoy", 1225));
        paperLibrary.addBook(new PaperBook("1984", "George Orwell", 328));
        paperLibrary.addBook(new PaperBook("The Catcher in the Rye", "J.D. Salinger", 277));

        System.out.println("Paper Books Library:");
        paperLibrary.listBooks();

        Library<EBook> eLibrary = new Library<>();
        eLibrary.addBook(new EBook("Clean Code", "Robert C. Martin", 1.5));
        eLibrary.addBook(new EBook("Effective Java", "Joshua Bloch", 2.0));
        eLibrary.addBook(new EBook("The Pragmatic Programmer", "Andrew Hunt", 2.8));

        System.out.println("\nE-Books Library before removal:");
        eLibrary.listBooks();

        System.out.println("\nSearching for 'Clean Code'...");
        EBook foundBook = eLibrary.findBook("Clean Code");
        if (foundBook != null) {
            System.out.println("Found: " + foundBook.getDescription());
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nRemoving 'Effective Java'...");
        boolean removed = eLibrary.removeBook("Effective Java");
        if (removed) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nE-Books Library after removal:");
        eLibrary.listBooks();
    }
}
