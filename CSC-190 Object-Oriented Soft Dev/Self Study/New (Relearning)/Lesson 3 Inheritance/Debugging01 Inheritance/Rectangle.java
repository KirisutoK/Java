public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height; // Changed
    }

    public void displayInfo() {
        super.displayInfo(); // Added
        System.out.println("Rectangle width: " + width);
        System.out.println("Rectangle height: " + height);
        System.out.println("Rectangle area: " + calculateArea());
    }
}
