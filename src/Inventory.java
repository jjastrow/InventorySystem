import java.util.HashMap;

/**
 * Inventory contains a list of items by Stock Number
 */
public class Inventory {
    private HashMap<Integer, InventoryItem> list = new HashMap();

    public void display(){
        System.out.println("Current Inventory:");
        System.out.println("\nStock:\tQty:\tType:\t\tName: ");
        System.out.println("------\t----\t-----\t\t------------------------");
        for ( InventoryItem item : list.values() ){
            System.out.println( String.format("%s\t\t%s\t\t%s\t\t%s (located %s)",
                    item.getStockNumber(), item.getQuantity(), item.getBook().type, item.getBook().name, item.getLocation()) );
        }
        System.out.println("________________________________________________________");
    }

    public boolean isInventoried(InventoryItem item){
        return list.containsValue(item);
    }
    public boolean isInStock(InventoryItem item){
        if (isInventoried(item)) return list.get(item).getQuantity() > 0;
        else return false;
    }

    public void putStock(InventoryItem item){
        list.put(item.getStockNumber(), item);
    }

    /* Add item into stock. Only increase quantity if item is already in stock.
       Otherwise, add new item into stock.
     */
    public void addToStock(InventoryItem item){
        if (isInventoried(item)) {
            System.out.println("(item is already in our inventory system) Increasing stock quantity...");
            InventoryItem chgItem = list.get(item);
            chgItem.addQty(item.getQuantity());
            putStock(chgItem);
            System.out.println( String.format("Added %s units of %s to inventory.",item.getQuantity(), item.getBook().name) );
        }
        else {
            putStock(item);
        }
    }

    private String requestStockNumber(){
        System.out.print("Enter unique stock number: ");
        return InventorySystem.scanner.nextLine();
    }

    private String requestStockNumber(boolean nan){
        System.out.print("Input MUST be numeric. Please enter unique stock number: ");
        return InventorySystem.scanner.nextLine();
    }

    public boolean isNumber(String input) {
       return input.matches("-?\\d+(\\.\\d+)?");
    }
}

