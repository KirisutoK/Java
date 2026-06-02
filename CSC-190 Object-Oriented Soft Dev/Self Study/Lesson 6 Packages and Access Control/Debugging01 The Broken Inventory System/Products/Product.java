package Products;

// Creation Date: June 02, 2026. at 2:00 PM
// Last Modified: June 02, 2026. at  2:08 PM

// inventory/products/Product.java

public class Product {
    protected String name;
    protected double price;
    protected int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public double calculateValue() { // <================== CHANGED INTO PUBLIC (ORIGINALLY PACKAGE-PRIVATE)
        return price * stock;
    }

    public void sell(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
            System.out.println("Sold " + quantity + "x " + name);
        } else {
            System.out.println("Not enough stock for " + name);
        }
    }
    public void displayInfo() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
    }
}
