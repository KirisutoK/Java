package Products;

// Creation Date: June 02, 2026. at 2:01 PM
// Last Modified: June 02, 2026. at  2:09 PM

// inventory/products/DigitalProduct.java

public class DigitalProduct extends Product {
    private String fileFormat;

    public DigitalProduct(String name, double price, String fileFormat) {
        super(name, price, 0);
        this.fileFormat = fileFormat;
    }

    @Override public double calculateValue() {
        return price;
    } // <================== CHANGED INTO PUBLIC (ORIGINALLY PACKAGE-PRIVATE)
    @Override public void sell(int quantity) {
        System.out.println("Sold digital product: " + name + " (" + fileFormat + ")");
    }
    @Override public void displayInfo() {
        super.displayInfo();
        System.out.println("Format: " + fileFormat);
    }
}
