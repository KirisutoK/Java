public class Main {
    public static void main(String[] args) {
        Item pizza = new Item("Pizza", 12.99);
        Item burger = new Item("Burger", 8.50);
        Item soda = new Item("Soda", 2.00);

        Customer customer1 = new Customer("Alice", 001);

        customer1.placeOrder(pizza);
        customer1.placeOrder(burger);
        customer1.placeOrder(soda);

        customer1.displayOrder();
    }
}