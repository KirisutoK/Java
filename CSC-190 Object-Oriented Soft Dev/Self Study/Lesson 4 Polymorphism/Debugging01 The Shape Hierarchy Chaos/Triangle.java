public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return (base * height) / 2;
    }

    public void displayInfo() {
        System.out.println("Shape: Triangle"); // ADDED
        System.out.println("Base: " + base);
        System.out.println("Height: " + height);
        super.displayInfo();
    }
}