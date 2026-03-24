public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public void displayInfo() {
        System.out.println("Shape: Rectangle"); // ADDED
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        super.displayInfo();
    }
}