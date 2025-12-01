public class Vehicle {
    protected String brand = " ";
    protected int year = 0;
    protected double price = 0.0;

    public Vehicle(String brand, int year, double price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
    
    //  GETTERS  \\

    public String getBrand() {
        return brand;
    }
    public int getYear() {
        return year;
    }
    public double getPrice() {
        return price;
    }


    // DISPLAYS \\
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }

    public void startEngine() { // ALL CHILDREN HAS THIS METHOD
        System.out.println(brand + " engine is starting...");
    }
}
