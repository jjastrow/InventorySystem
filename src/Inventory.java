import java.util.HashMap;

/**
 * Inventory contains a list of items by Stock Number
 */
public class Inventory {
    private HashMap<Integer, InventoryItem> list = new HashMap();

    public void display(){
        System.out.println("Current Inventory:");
        System.out.println("\nStock:\tQty:\tType:\t\t\tName: ");
        System.out.println("------\t----\t-----\t\t\t------------------------");
        for ( InventoryItem item : list.values() ){
            System.out.println( String.format("%s\t\t%s\t\t%s\t\t\t%s (located %s)",
                    item.getStockNumber(), item.getQuantity(), item.getBook().type, item.getBook().name, item.getLocation()) );
        }
        System.out.println("________________________________________________________");
    }

    public boolean isInventoried(InventoryItem item){
        return list.containsValue(item);
    }
    public boolean isInventoried(Integer num){
        return list.containsKey(num);
    }

    public boolean isInStock(InventoryItem item){
        if (isInventoried(item)) return (list.get(item.getStockNumber()).getQuantity() > 0);
        else return false;
    }
    public boolean isInStock(Integer num){
        if (isInventoried(num)) return (list.get(num).getQuantity() > 0);
        else return false;
    }

    public void putStock(InventoryItem item){
        list.put(item.getStockNumber(), item);
    }

    public void removeStock(){
        int num = Integer.parseInt(requestStockNumber());
        if (isInventoried(num)){
            list.remove(num);
        }
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

    public void updateStock(){
        int num = Integer.parseInt(requestStockNumber());
        if (isInventoried(num)){
            System.out.print("Enter quantity: ");
            String input = InventorySystem.scanner.nextLine();
            if (isNumber(input)){
                int qty = Integer.parseInt(input);
                if (qty >= 0) {
                    list.get(num).setQuantity(qty);
                }
                else System.out.println("Negative numbers not allowed!");
            }
            else System.out.println("MUST be numeric!");
        }
        else System.out.println(String.format("Item %s not found!", num));
    }

    private String requestStockNumber(){
        System.out.print("Enter stock number: ");
        return InventorySystem.scanner.nextLine();
    }

    public boolean isNumber(String input) {
       return input.matches("-?\\d+(\\.\\d+)?");
    }
}

