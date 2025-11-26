public class Cars {
    // ATTRIBUTES OR VARIABLES
    private String Name; // Private means it cant be accessed outside
    private int Price;

    public Cars(String name, int price) {
        this.Name = name;
        this.Price = price;
    }

    public void displayInfo() {
        System.out.println("Name: " + Name);
        System.out.println("Price: " + Price);
    }
}
