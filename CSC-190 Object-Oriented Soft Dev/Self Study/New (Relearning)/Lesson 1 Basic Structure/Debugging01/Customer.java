public class Customer {
    private String CustomerName;
    private int CustomerID;
    private Order CustomerOrder;

    public Customer(String name, int id) {
        this.CustomerName = name;
        this.CustomerID = id;
        Order CustomerOrder = new Order();  // BUG HERE - Order constructor needs parameter
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