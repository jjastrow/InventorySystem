/**
 * Created by johnjastrow on 4/4/16.
 */
class InventoryItem {
    private int stockNumber;
    private Book book;
    private int quantity;
    private String location;

    public InventoryItem(){}

    public InventoryItem(int stockNumber, Book book, int quantity, String location) {
        this.book = book;
        this.quantity = quantity;
        this.location = location;
        this.stockNumber = stockNumber;
    }

    public static InventoryItem requestNewItem(){
        InventoryItem item = new InventoryItem();

        System.out.println("Enter Stock Number: ");
        String stock = InventorySystem.scanner.nextLine();
        item.setStockNumber(Integer.parseInt(stock));
        item.setBook(Book.requestBook());

        System.out.println("Enter quantity: ");
        String qty = InventorySystem.scanner.nextLine();
        item.setQuantity(Integer.parseInt(qty));

        System.out.println("Enter location of stock item: ");
        item.setLocation(InventorySystem.scanner.nextLine());

        return item;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public boolean addQty(int quantity){
        if (quantity > 0) {
            this.quantity += quantity;
            return true;
        }else return false;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}