public class Cars {
    private String Name; // Private means it cant be accessed outside
    private int Price;

    public Cars(String name, int price) {
        this.Name = name;
        this.Price = price;
    }

    public String getName() { // we used this in order to get the private variables
        return Name;
    }

    public int getPrice() {
        return Price;
    }
}
