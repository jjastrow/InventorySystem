/**
 * Created by johnjastrow on 4/4/16.
 */
class Book{
    String name;
    BookType type;

    public static enum BookType{ Satire, Fiction, Romance, Mystery, Drama }

    public Book() {
    }

    // Default book to Fiction
    public Book(String name) {
        this.name = name;
        this.type = BookType.Fiction;
    }

    // Allow any type book
    public Book(String name, BookType type) {
        this.name = name;
        this.type = type;
    }

    public static Book requestBook(){
        System.out.print("Enter book name: ");
        String name = InventorySystem.scanner.nextLine();

        int i = 1;
        for (BookType t : BookType.values()){
            System.out.println( String.format("%s - %s", i++, t) );
        }
        System.out.print("Enter type of book: ");
        String typeString = InventorySystem.scanner.nextLine();
        int typeIndex = Integer.parseInt(typeString);

        return new Book(name, BookType.values()[typeIndex-1]);
    }
}
