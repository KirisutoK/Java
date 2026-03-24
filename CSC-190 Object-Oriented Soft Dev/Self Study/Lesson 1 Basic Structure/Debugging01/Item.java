public class Item {
    private String ItemName;
    private double Price;

    public Item(String itemname, double price) {
        this.ItemName = itemname;
        this.Price = price;  // BUG HERE
    }

    public String getItemName() {
        return ItemName;
    }

    public double getPrice() {
        return Price;
    }

    public void displayItem() {
        System.out.println(ItemName + " - $" + Price);
    }
}