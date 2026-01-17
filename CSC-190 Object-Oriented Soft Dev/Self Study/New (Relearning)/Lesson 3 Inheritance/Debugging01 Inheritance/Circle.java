public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color); // Changed
        this.radius = radius;
    }

    @Override // Added
    public double calculateArea() {
        return Math.PI * radius * radius; // A = π r^2
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Circle radius: " + radius);
        System.out.println("Circle area: " + calculateArea());
    }
}
