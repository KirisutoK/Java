public class Order {
    private Item[] items;
    private int itemCount;

    //===========GETTERS===========\\

    //===========SETTERS===========\\

    public Order(int maxItems) {
        items = new Item[maxItems];
        itemCount = 0;
    }

    public void addItem(Item item) {
        if (itemCount > items.length) {  // BUG HERE - wrong comparison
            System.out.println("Order is full!");
        } else {
            items[itemCount] = item;
            itemCount++;
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i <= itemCount; i++) {  // BUG HERE - array bounds
            total += items[i].getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order Items:");
        for (int i = 0; i < itemCount; i++) {
            items[i].displayItem();
        }
        System.out.println("Total: $" + calculateTotal());
    }
}