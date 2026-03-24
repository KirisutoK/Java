public class Customer {
    private String CustomerName;
    private int CustomerID;
    private Order CustomerOrder;

    public Customer(String name, int id) {
        this.CustomerName = name;
        this.CustomerID = id;
        CustomerOrder = new Order(20);  // BUG HERE - Order constructor needs parameter // Solution: All customers who order has a limit of 20 orders (can be flexible with ArrayList)
    }

    public void placeOrder(Item item) {
        CustomerOrder.addItem(item);
    }

    public void displayOrder() {
        System.out.println("Customer: " + CustomerName);
        System.out.println("Order ID: " + CustomerID);
        CustomerOrder.displayOrder();
    }
}