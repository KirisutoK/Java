package Store;

// Creation Date: June 02, 2026. at 2:02 PM
// Last Modified: June 02, 2026. at  2:04 PM

// inventory/store/Store.java
import Products.Product;

public class Store {
    private String storeName;
    private Product[] products;
    private int productCount;

    public Store(String storeName) {
        this.storeName = storeName;
        products = new Product[10];
        productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount >= products.length) {
            System.out.println("Store is full!");
            return;
        }
        products[productCount] = product;
        productCount++;
        System.out.println(product.getName() + " added to " + storeName);
    }
    public void sellProduct(String name, int quantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                products[i].sell(quantity);
                return;
            }
        }
        System.out.println("Product not found: " + name);
    }
    public double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].calculateValue();
        }
        return total;
    }
    public void displayAllProducts() {
        System.out.println("=== " + storeName + " ===");
        for (int i = 0; i < productCount; i++) {
            products[i].displayInfo();
            System.out.println();
        }
    }
}
