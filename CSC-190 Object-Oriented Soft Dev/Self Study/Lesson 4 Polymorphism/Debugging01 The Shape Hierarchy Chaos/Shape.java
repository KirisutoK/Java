public class Shape {
    protected String color;

    public Shape() {
        this.color = "Unknown";
    }

    public double getArea() {
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("Shape color: " + color);
        System.out.println("Area: " + getArea());
    }
}