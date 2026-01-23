public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void displayInfo() { // VERY MESSY DISPLAY
        System.out.println("Shape: Circle");
        System.out.println("Radius: " + radius);
        super.displayInfo();
    }
}