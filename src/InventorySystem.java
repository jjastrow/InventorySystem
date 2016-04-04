import java.util.Scanner;

/** Inventory system keeps track of Inventory items
 * Inventory Item contains: name, quantity, shelf location
 */
public class InventorySystem {
    public static Scanner scanner = new Scanner(System.in);
    private static Inventory items = new Inventory();

    public static void main(String[] args) {
        System.out.println("Welcome to my InventorySystem System");

        // Start with some default inventory
        items.putStock(new InventoryItem(101, new Book("The Ghosts"), 10, "top shelf"));
        items.putStock(new InventoryItem(102, new Book("Voyager 3", Book.BookType.Mystery), 1, "in the closet"));
        items.display();

        addInventory();
    }


    private static void addInventory(){
        String input;
        System.out.println("Let's add some more inventory...");

        while (true) {
            System.out.println("\n...More items to [A]dd, [R]emore, [U]pdate, or [D]isplay all then add, or [Q]uit? ");
            switch (InventorySystem.scanner.nextLine().toUpperCase()) {
                case "A": {
                    items.addToStock(InventoryItem.requestNewItem());
                    continue;
                }
                case "D": {
                    items.display(); continue;
                }
                case "R": {
                    items.removeStock(); continue;
                }
                case "U": {
                    items.updateStock(); continue;
                }
                case "Q": return;
                default:;
            }
            items.addToStock(InventoryItem.requestNewItem());
        }
    }
}

